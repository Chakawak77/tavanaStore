package com.tavana.tavanastore.dto;

import com.tavana.tavanastore.common.BaseDTO;
import com.tavana.tavanastore.entity.Company;
import com.tavana.tavanastore.entity.Product;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends BaseDTO {

    private String title;
    private String icon;
    private Long price;

    private Company company;

    private Integer like;

    private Integer desLike;


    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getDesLike() {
        return desLike;
    }

    public void setDesLike(Integer desLike) {
        this.desLike = desLike;
    }

    public ProductDTO(Product product) {
        this.title = product.getTitle();
        this.icon = product.getIcon();
        this.price=product.getPrice();

    }

    public Product map(){
        Product product=new Product();
        product.setId(getId());
        product.setTitle(title);
        product.setIcon(icon);
        product.setPrice(price);
        return product;
    }

}
