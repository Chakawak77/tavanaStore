package com.tavana.tavanastore.entity;

import com.sun.istack.NotNull;
import com.tavana.tavanastore.common.BaseEntity;
import lombok.Data;
import javax.persistence.*;
@Entity
@Data
@Table(name = "tbl_comment")
public class Comment extends BaseEntity {

    @NotNull
    @Column(name = "content")
    private String content;
    private Long productId;
    private Long customerId;


    @ManyToOne
    @JoinColumn(name = "comment_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Customer customer;


}
