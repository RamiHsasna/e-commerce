package com.ecommerce.springboot.model;
import jakarta.persistence.*;
import lombok.Data;
import com.ecommerce.springboot.model.Category;

import java.math.BigDecimal;

@Data
@Entity
@Table(name="product")

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="product_id")
    private Long product_id;

    @Column(name = "product_name")
    private String product_name;

    @Column(name = "product_price")
    private BigDecimal product_price;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "category_id",nullable = false)
    private Category category;
}
