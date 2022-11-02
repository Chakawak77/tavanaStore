package com.tavana.tavanastore.repository;

import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review,Long> {



    @Query(value = "SELECT * FROM tbl_review WHERE customerId = : customerId",nativeQuery = true)
    List<Review> findAllByCustomer_Id(Long customerId);

    @Query(value = "SELECT * FROM tbl_review WHERE product_Id = :productId",nativeQuery = true)
    List<Review>  findAllByProduct_Id(Long productId);

    @Query(value = "SELECT count(*) FROM tbl_review WHERE product_Id =:productId and score = 1",nativeQuery = true)
    Integer findAllByProduct_Like(Long productId);

    @Query(value = "SELECT count(*) FROM tbl_review WHERE product_Id =: productId and score = 0",nativeQuery = true)
    Integer findAllByProduct_DesLike(Long productId);

 }
