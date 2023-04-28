package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.*;


@Entity() //Tao table Customer
@Table(name = "customer")
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column
    private String name;
    @Column
    private String email;
    @Column
    private Integer age;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;


}
