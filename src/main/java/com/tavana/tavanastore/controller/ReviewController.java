package com.tavana.tavanastore.controller;

import com.tavana.tavanastore.dto.CompanytDTO;
import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.entity.Review;
import com.tavana.tavanastore.service.CompanyService;
import com.tavana.tavanastore.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/review/")
public class ReviewController {
    private final ReviewService service;


    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllById(id));
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> save(@RequestBody ReviewDTO reviewDTO) {
        service.save(reviewDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<ReviewDTO> update(@RequestBody ReviewDTO reviewDTO) {
         return ResponseEntity.ok((service.update(reviewDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    @GetMapping("/review/{customer}")
    public ResponseEntity<List<ReviewDTO>> findAllByCustomer_Id(@PathVariable Long customer) {
        List<ReviewDTO> reviews = service.findAllByCustomer_Id(customer);
        return ResponseEntity.ok(reviews);
    }

    @GetMapping("/review/{productId}")
    public ResponseEntity<List<ReviewDTO>> findAllByProduct_Id(@PathVariable Long productId) {
        List<ReviewDTO> reviews = service.findAllByProduct_Id(productId);
        return ResponseEntity.ok(reviews);
    }
 }
