package com.tavana.tavanastore.service_imp;

import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.entity.Customer;
import com.tavana.tavanastore.repository.CustomerRepository;
import com.tavana.tavanastore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CustomerServiceImp implements CustomerService {

     private final CustomerRepository repository;

    @Override
    public CustomerDTO save(CustomerDTO customerDTO) {
        Customer customer = customerDTO.map();
        customer = repository.save(customer);
        return CustomerDTO
                .builder()
                .address(customer.getAddress())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();
    }

    @Override
    public CustomerDTO update(CustomerDTO customerDTO) {

        CustomerDTO updateCustomerDTO = findById(customerDTO.getId());
        Customer customer = customerDTO.map();
        customer = repository.save(customer);
        return CustomerDTO
                .builder()
                .address(customer.getAddress())
                .name(customer.getName())
                .phone(customer.getPhone())
                .build();

    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);

    }

    @Override
    public CustomerDTO findById(Long id) {
        Optional<Customer> optionalCustomer = repository.findById(id);
        if (optionalCustomer.isEmpty())
            throw new RuntimeException("Not Found!");
        return new CustomerDTO(optionalCustomer.get());
    }
}
