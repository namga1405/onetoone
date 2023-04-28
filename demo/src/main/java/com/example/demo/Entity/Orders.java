package com.example.demo.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column
    private String product_name;

    @Column
    private Integer number_bought;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
}
