package com.example.demo.dto;

import com.example.demo.Entity.Address;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerDto {
    private Integer id;
    private String name;
    private String email;

    private Integer age;

    private Address address;
}
