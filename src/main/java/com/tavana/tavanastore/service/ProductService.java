package com.tavana.tavanastore.service;

import com.tavana.tavanastore.dto.ProductDTO;

public interface ProductService {

    ProductDTO save(ProductDTO productDTO);

    ProductDTO update(ProductDTO productDTO);

    void delete(Long id);

    ProductDTO findById(Long id);
}
