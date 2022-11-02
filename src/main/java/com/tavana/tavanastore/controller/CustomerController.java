package com.tavana.tavanastore.controller;

import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.service.CustomerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/customer")
public class CustomerController {
    private final CustomerService service;


    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok( service.findById(id));
    }

    @PostMapping
    public ResponseEntity<Void> save(@RequestBody CustomerDTO customerDTO) {
        service.save(customerDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CustomerDTO> update(@RequestBody CustomerDTO customerDTO) {
         return ResponseEntity.ok((service.update(customerDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

 }
