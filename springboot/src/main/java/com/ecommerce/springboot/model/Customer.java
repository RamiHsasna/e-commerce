package com.ecommerce.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="customer")

public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="customer_id")
    private Long customer_id;

    @Column(name = "fullname")
    private String fullname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;
}

