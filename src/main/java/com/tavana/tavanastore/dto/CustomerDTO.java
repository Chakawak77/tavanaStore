package com.tavana.tavanastore.dto;

import com.tavana.tavanastore.common.BaseDTO;
import com.tavana.tavanastore.entity.Customer;
import lombok.*;

@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDTO extends BaseDTO {

    private String name;
    private String address;
    private String phone;

    public CustomerDTO(Customer customer) {
        this.address = customer.getAddress();
        this.name = customer.getName();
        this.phone = customer.getPhone();
    }

    public Customer map(){
        Customer customer = new Customer();
        customer.setId(getId());
        customer.setAddress(address);
        customer.setName(name);
        customer.setPhone(phone);
        return customer;
    }

}
