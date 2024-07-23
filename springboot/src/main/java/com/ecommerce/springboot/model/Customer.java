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

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    public long getId() {
        return customer_id;
    }
    public void setId(long customer_id) {
        this.customer_id = customer_id;
    }

    public String getFirstName() {
        return firstname;
    }
    public void setFirstName(String firstname) {
        this.firstname = Customer.this.firstname;
    }

    public String getLastame() {
        return lastname;
    }
    public void setLastName(String lastname) {
        this.lastname = Customer.this.lastname;
    }

    public String getMail() {
        return email;
    }
    public void setMail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }
    public void setPasswordd(String password) {
        this.password = password;
    }
}

