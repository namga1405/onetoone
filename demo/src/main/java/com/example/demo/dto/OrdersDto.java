package com.example.demo.dto;

import com.example.demo.Entity.Address;
import com.example.demo.Entity.Customer;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrdersDto {
    private Integer id;

    private String product_name;

    private Integer number_bought;
    private Address address;

}
