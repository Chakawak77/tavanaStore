package com.tavana.tavanastore.dto;

import com.tavana.tavanastore.common.BaseDTO;
import com.tavana.tavanastore.entity.Review;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReviewDTO extends BaseDTO {

    private Boolean score;
    private Long productId;
    private Long customerId;

    public ReviewDTO(Review review){
        this.score=review.getScore();
        this.productId=review.getProduct().getId();
        this.customerId=review.getCustomer().getId();
    }
    public Review map(){
        Review review=new Review();
        review.setId(getId());
        review.setScore(score);
        review.setProductIds(productId);
        review.setCustomerIds(customerId);
        return review;
    }
}
