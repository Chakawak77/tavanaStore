package com.tavana.tavanastore.dto;

import com.tavana.tavanastore.common.BaseDTO;
import com.tavana.tavanastore.entity.Comment;
import com.tavana.tavanastore.entity.Review;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentDTO extends BaseDTO {

    private String content;
    private Long productId;
    private Long customerId;

    public CommentDTO(Comment comment){
        this.content=comment.getContent();
        this.productId=comment.getProduct().getId();
        this.customerId=comment.getCustomer().getId();
    }

    public Comment map(){
        Comment comment=new Comment();
        comment.setId(getId());
        comment.setContent(content);
        comment.setProductId(productId);
        comment.setCustomerId(customerId);
        return comment;
    }
}
