package com.tavana.tavanastore.service_imp;

import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.dto.ProductDTO;
import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.entity.Review;
import com.tavana.tavanastore.repository.ReviewRepository;
import com.tavana.tavanastore.service.CustomerService;
import com.tavana.tavanastore.service.ProductService;
import com.tavana.tavanastore.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ReviewServiceImp implements ReviewService {
    private final ReviewRepository repository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Override
    public ReviewDTO save(ReviewDTO reviewDTO) {
        Long productId = reviewDTO.getProductId();
        CustomerDTO customerDTO = customerService.findById(productId);
        ProductDTO productDTO = productService.findById(productId);
        Review review=reviewDTO.map();
        review.setCustomerIds(customerDTO.getId());
        review.setProductIds(productDTO.getId());
        review = repository.save(review);
        return ReviewDTO
                .builder()
                .score(review.getScore())
                .productId(review.getProductIds())
                .customerId(review.getCustomerIds())
                .build();
    }

    @Override
    public ReviewDTO update(ReviewDTO reviewDTO) {
        ReviewDTO updateReviewDTO = findAllById(reviewDTO.getId());
        Review review=reviewDTO.map();
        review = repository.save(review);
        return ReviewDTO
                .builder()
                .score(review.getScore())
                .productId(review.getProductIds())
                .customerId(review.getCustomerIds())
                .build();
    }

    @Override
    public void delete(Long id) {
        findAllById(id);
        repository.deleteById(id);
    }

    @Override
    public ReviewDTO findAllById(Long id) {
        Optional<Review> optionalReview = repository.findById(id);
        if (optionalReview.isEmpty())
            throw new RuntimeException("Not Found!");
        return new ReviewDTO(optionalReview.get());
    }

    @Override
    public List<ReviewDTO> findAllByCustomer_Id(Long customerId) {
        List<Review> reviews = repository.findAllByCustomer_Id(customerId);
        return reviews
                .stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<ReviewDTO> findAllByProduct_Id(Long productId) {
        List<Review> reviews = repository.findAllByProduct_Id(productId);
        return reviews
                .stream()
                .map(ReviewDTO::new)
                .collect(Collectors.toList());    }
}
