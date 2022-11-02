package com.tavana.tavanastore.service;


import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.entity.Customer;

public interface CustomerService {

    CustomerDTO save(CustomerDTO customerDTO);

    CustomerDTO update(CustomerDTO customerDTO);

    void delete(Long id);

    CustomerDTO findById(Long id);
}