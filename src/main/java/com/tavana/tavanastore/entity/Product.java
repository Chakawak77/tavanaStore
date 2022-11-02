package com.tavana.tavanastore.entity;

import com.sun.istack.NotNull;
import com.tavana.tavanastore.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_product")
public class Product extends BaseEntity {

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Column(name = "icon")
    private String icon;


    @NotNull
    @Column(name = "price")
    private Long price;

//    @NotNull
//    private Long like;
//
//    @NotNull
//    private Long desLike;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private Company company;


    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Comment> comments;

    @OneToMany(mappedBy = "product",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Review> reviews;
}
