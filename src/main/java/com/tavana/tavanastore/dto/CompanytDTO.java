package com.tavana.tavanastore.dto;

import com.tavana.tavanastore.common.BaseDTO;
import com.tavana.tavanastore.entity.Company;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompanytDTO extends BaseDTO {

    private String name;
    private String logo;
    private String address;

    public CompanytDTO(Company company) {
        this.name = company.getName();
        this.logo = company.getLogo();
        this.address=company.getAddress();
    }

    public Company map(){
        Company company=new Company();
        company.setId(getId());
        company.setAddress(address);
        company.setLogo(logo);
        company.setName(name);
        return company;
    }

}
