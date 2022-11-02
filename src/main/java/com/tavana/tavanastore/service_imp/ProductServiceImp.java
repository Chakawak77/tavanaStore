package com.tavana.tavanastore.service_imp;

import com.tavana.tavanastore.dto.ProductDTO;
import com.tavana.tavanastore.entity.Product;
import com.tavana.tavanastore.entity.Review;
import com.tavana.tavanastore.repository.ProductRepository;
import com.tavana.tavanastore.repository.ReviewRepository;
import com.tavana.tavanastore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImp implements ProductService {
    private final ProductRepository repository;
    private final ReviewRepository reviewRepository;


    @Override
    public ProductDTO save(ProductDTO productDTO) {
         Product product=productDTO.map();
         product = repository.save(product);
        return ProductDTO
                .builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .icon(product.getIcon())
                .build();
     }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        ProductDTO updateProductDTO = findById(productDTO.getId());
        Product product=productDTO.map();
        product = repository.save(product);
        return ProductDTO
                .builder()
                .title(product.getTitle())
                .price(product.getPrice())
                .icon(product.getIcon())
                .build();
    }

    @Override
    public void delete(Long id) {
        findById(id);
        repository.deleteById(id);
    }

    @Override
    public ProductDTO findById(Long id) {
        Optional<Product> optionalProduct = repository.findById(id);
        if (optionalProduct.isEmpty())
            throw new RuntimeException("Not Found!");

        Integer like=reviewRepository.findAllByProduct_Like(id);
        Integer desLike= reviewRepository.findAllByProduct_DesLike(id);

        ProductDTO productDTO = new ProductDTO(optionalProduct.get());
        productDTO.setLike(like);
        productDTO.setLike(desLike);
        return productDTO;
    }
}
