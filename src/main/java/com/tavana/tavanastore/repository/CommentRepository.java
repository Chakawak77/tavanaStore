package com.tavana.tavanastore.repository;

import com.tavana.tavanastore.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    @Query(value = "SELECT * FROM tbl_comment where user_id = :userId", nativeQuery = true)
    List<Comment> findAllByUser_Id(Long userId);

    @Query(value = "SELECT * FROM tbl_review WHERE customerId = : customerId", nativeQuery = true)
    List<Comment> findAllByCustomer_Id(Long customerId);

    @Query(value = "SELECT * FROM tbl_review WHERE product_Id = :productId", nativeQuery = true)
    List<Comment> findAllByProduct_Id(Long productId);

}
