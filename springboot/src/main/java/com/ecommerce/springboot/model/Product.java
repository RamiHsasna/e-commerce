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

    //Getters and setters
    public String getProduct_name() {
        return product_name;
    }
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public BigDecimal getProduct_price() {
        return product_price;
    }
    public void setProduct_price(BigDecimal product_price) {
        this.product_price = product_rpice;
    }

    public Long getProduct_id() {
        return product_id;
    }
    public void setProduct_id(Long product_id) {
        this.product_id = product_id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }
    public void setCategory(Category category) {
        this.category = category;
    }
}
