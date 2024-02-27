package com.example.gameshop.models.view_models;

import org.hibernate.annotations.Immutable;

@Immutable
public class RatingsPerCutomerDTO {
    private Long customerId;
    private String name;
    private Double averageRating;
    private Long totalOrders;
    private Integer totalAmountPaid;

    public Long getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }

    public Long getTotalOrders() {
        return this.totalOrders;
    }

    public void setTotalOrders(Long totalOrders) {
        this.totalOrders = totalOrders;
    }

    public Integer getTotalAmountPaid() {
        return this.totalAmountPaid;
    }

    public void setTotalAmountPaid(Integer totalAmountPaid) {
        this.totalAmountPaid = totalAmountPaid;
    }
}
