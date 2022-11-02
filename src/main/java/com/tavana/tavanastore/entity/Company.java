package com.tavana.tavanastore.entity;

import com.sun.istack.NotNull;
import com.tavana.tavanastore.common.BaseEntity;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "tbl_company")
public class Company extends BaseEntity {

    @NotNull
    @Column(name = "first_name")
    private String name;

    @NotNull
    @Column(name = "logo")
    private String logo;

    @NotNull
    @Column(name = "address")
    private String address;

    @OneToMany(mappedBy = "company",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Product> productList;

}
