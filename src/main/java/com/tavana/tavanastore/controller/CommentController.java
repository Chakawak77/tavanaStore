package com.tavana.tavanastore.controller;

import com.tavana.tavanastore.dto.CommentDTO;
import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.service.CommentService;
import com.tavana.tavanastore.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/v1/comment")
public class CommentController {
    private final CommentService service;


    @GetMapping("/{id}")
    public ResponseEntity<CommentDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findAllById(id));
    }

    @PostMapping
    public ResponseEntity<CommentDTO> save(@RequestBody CommentDTO commentDTO) {
        service.save(commentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<CommentDTO> update(@RequestBody CommentDTO commentDTO) {
        return ResponseEntity.ok((service.update(commentDTO)));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/comment/{customerId}")
    public ResponseEntity<List<CommentDTO>> findAllByCustomer_Id(@PathVariable Long customerId) {
        List<CommentDTO> commentDTOS = service.finAllByCustomer_Id(customerId);
        return ResponseEntity.ok(commentDTOS);
    }

    @GetMapping("/comment/{productId}")
    public ResponseEntity<List<CommentDTO>> findAllByProduct_Id(@PathVariable Long productId) {
        List<CommentDTO> commentDTOS = service.finAllByProduct_Id(productId);
        return ResponseEntity.ok(commentDTOS);
    }
}