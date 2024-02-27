package com.example.gameshop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "payment", schema = "gameshop")
public class Payment {
    @Id
    @Column(name = "payment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentId;

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    @Column(name = "amount")
    private Integer amount;

    @Column(name = "payment_method")
    private String paymentMethod;

    public Integer getPaymentId() {
        return this.paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getAmount() {
        return this.amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return this.paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }
}
