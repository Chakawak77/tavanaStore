package com.tavana.tavanastore.repository;

import com.tavana.tavanastore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {

    @Query(value = "SELECT * FROM tbl_product",nativeQuery = true)
    List<Product> findAllByProduct(Long id);

}
