package com.tavana.tavanastore.service;


import com.tavana.tavanastore.dto.CommentDTO;
import com.tavana.tavanastore.entity.Comment;
import java.util.List;

public interface CommentService {

    CommentDTO save(CommentDTO commentDTO);

    CommentDTO update(CommentDTO commentDTO);

    void delete(Long id);

    CommentDTO findAllById(Long id);

    List<CommentDTO> finAllByCustomer_Id(Long userId);

    List<CommentDTO> finAllByProduct_Id(Long productId);
}
