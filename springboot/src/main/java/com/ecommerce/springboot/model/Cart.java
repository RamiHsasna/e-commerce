package com.ecommerce.springboot.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table (name="cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name ="cart_id")
    private long cart_id;

    @ManyToOne
    @JoinColumn (name = "customer_id",nullable = false)
    private Customer customer;

    //Getters and setters
    public void setCart(long cart_id){
        this.cart_id = cart_id;
    }
    public long getCart(){
        return cart_id;
    }

    public Customer getCustomer() {
        return customer;
    }
}
