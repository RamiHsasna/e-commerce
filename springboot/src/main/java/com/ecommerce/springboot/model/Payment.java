package com.ecommerce.springboot.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import jakarta.persistence.*;


@Data
@Entity
@Table (name="payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="payment_id", nullable = false)
    private long payment_id;

    @Column (name="type")
    private String type;

    @Column (name= "amount")
    private BigDecimal amount;

    @OneToOne
    @JoinColumn (name="order_id", nullable = false)
    private Order order;

    //Getters and setters

    public long getPayment_id() {
        return payment_id;
    }
    public void setPayment_id(long payment_id) {
        this.payment_id = payment_id;
    }

    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getAmount() {
        return amount;
    }
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Order getOrder() {
        return order;
    }
    public void setOrder(Order order) {
        this.order = order;
    }
}
