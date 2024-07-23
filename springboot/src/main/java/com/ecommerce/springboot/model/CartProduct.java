package com.ecommerce.springboot.model;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "cart_product")
public class CartProduct {

    @EmbeddedId
    private CartProductId id;

    @ManyToOne
    @MapsId("cartId")
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @ManyToOne
    @MapsId("productId")
    @JoinColumn(name = "product_id")
    private Product product;

    // Getters and Setters
    @Embeddable
    class CartProductId implements Serializable {
        @Column(name = "cart_id")
        private Long cartId;

        @Column(name = "product_id")
        private Long productId;

        // Getters, Setters, hashCode, equals
    }
}

