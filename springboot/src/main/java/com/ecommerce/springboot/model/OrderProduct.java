package com.ecommerce.springboot.model;

import jakarta.persistence.*;

import java.io.Serializable;


@Entity
@Table(name = "order_product")
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    @ManyToOne
    @MapsId("orderId")
    @JoinColumn(name = "order_id")
    private Order order;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and Setters
    @Embeddable
    public class OrderProductId implements Serializable {
        @Column(name = "order_id")
        private Long orderId;

        @Column(name = "product_id")
        private Long productId;

        // Getters, Setters, hashCode, equals
    }
}


