package com.tavana.tavanastore.service_imp;

import com.tavana.tavanastore.dto.CommentDTO;
import com.tavana.tavanastore.dto.CustomerDTO;
import com.tavana.tavanastore.dto.ProductDTO;
import com.tavana.tavanastore.dto.ReviewDTO;
import com.tavana.tavanastore.entity.Comment;
import com.tavana.tavanastore.entity.Review;
import com.tavana.tavanastore.repository.CommentRepository;
import com.tavana.tavanastore.service.CommentService;
import com.tavana.tavanastore.service.CustomerService;
import com.tavana.tavanastore.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CommentServiceImp implements CommentService {

    private final CommentRepository repository;
    private final CustomerService customerService;
    private final ProductService productService;

    @Override
    public CommentDTO save(CommentDTO commentDTO) {
        Long productId = commentDTO.getProductId();
        CustomerDTO customerDTO = customerService.findById(productId);
        ProductDTO productDTO = productService.findById(productId);
        Comment comment = commentDTO.map();
        comment.setCustomerId(customerDTO.getId());
        comment.setProductId(productDTO.getId());
        comment = repository.save(comment);
        return CommentDTO
                .builder()
                .content(comment.getContent())
                .productId(comment.getProductId())
                .customerId(comment.getCustomerId())
                .build();
    }

    @Override
    public CommentDTO update(CommentDTO commentDTO) {
        CommentDTO updateCommentDTO = findAllById(commentDTO.getId());
        Long productId = commentDTO.getProductId();
        CustomerDTO customerDTO = customerService.findById(productId);
        ProductDTO productDTO = productService.findById(productId);
        Comment comment = commentDTO.map();
        comment.setCustomerId(customerDTO.getId());
        comment.setProductId(productDTO.getId());
        comment = repository.save(comment);
        return CommentDTO
                .builder()
                .content(comment.getContent())
                .productId(comment.getProductId())
                .customerId(comment.getCustomerId())
                .build();
    }

    @Override
    public void delete(Long id) {
        findAllById(id);
        repository.deleteById(id);
    }

    @Override
    public CommentDTO findAllById(Long id) {
        Optional<Comment> optionalComment = repository.findById(id);
        if (optionalComment.isEmpty())
            throw new RuntimeException("Not Found!");
        return new CommentDTO(optionalComment.get());
    }

    @Override
    public List<CommentDTO> finAllByCustomer_Id(Long userId) {
        List<Comment> comments = repository.findAllByUser_Id(userId);
        return comments
                .stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public List<CommentDTO> finAllByProduct_Id(Long productId) {
        List<Comment> comments = repository.findAllByProduct_Id(productId);
        return comments
                .stream()
                .map(CommentDTO::new)
                .collect(Collectors.toList());
    }
}
