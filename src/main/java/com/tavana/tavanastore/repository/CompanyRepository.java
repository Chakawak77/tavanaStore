package com.tavana.tavanastore.repository;

import com.tavana.tavanastore.entity.Company;
import com.tavana.tavanastore.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company,Long> {

    @Query(value = "SELECT * FROM tbl_company",nativeQuery = true)
    List<Company> findAllByCompany_Id(Long id);

}
