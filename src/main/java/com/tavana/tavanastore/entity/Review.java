package com.tavana.tavanastore.entity;

import com.sun.istack.NotNull;
import com.tavana.tavanastore.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@Table(name = "tbl_review")
public class Review extends BaseEntity {

    @NotNull
    private Boolean score;
    private Long productIds;
    private Long customerIds;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

}
