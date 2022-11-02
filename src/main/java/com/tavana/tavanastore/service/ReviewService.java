package com.tavana.tavanastore.service;


import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.entity.Review;
import java.util.List;

public interface ReviewService {

    ReviewDTO save(ReviewDTO reviewDTO);

    ReviewDTO update(ReviewDTO reviewDTO);

    void delete(Long id);

    ReviewDTO findAllById(Long id);

    List<ReviewDTO> findAllByCustomer_Id(Long customerId);
    List<ReviewDTO> findAllByProduct_Id(Long productId);
}
