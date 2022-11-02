package com.tavana.tavanastore.controller;

import com.tavana.tavanastore.dto.CompanytDTO;
import com.tavana.tavanastore.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/company")
public class CompanyController {
    private final CompanyService service;


    @GetMapping("/{id}")
    public ResponseEntity<CompanytDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PostMapping
    public ResponseEntity<CompanytDTO> save(@RequestBody CompanytDTO companytDTO) {
        service.save(companytDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CompanytDTO> update(@RequestBody CompanytDTO companytDTO) {
         return ResponseEntity.ok((service.update(companytDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

 }
