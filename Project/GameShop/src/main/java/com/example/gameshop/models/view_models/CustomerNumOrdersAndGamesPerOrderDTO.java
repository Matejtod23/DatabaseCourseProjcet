package com.example.gameshop.models.view_models;

import org.hibernate.annotations.Immutable;

@Immutable
public class CustomerNumOrdersAndGamesPerOrderDTO {
    private Long customerId;
    private String name;
    private String email;
    private Integer numOrders;
    private Integer avgGamesPerOrder;

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

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNumOrders() {
        return this.numOrders;
    }

    public void setNumOrders(Integer numOrders) {
        this.numOrders = numOrders;
    }

    public Integer getAvgGamesPerOrder() {
        return this.avgGamesPerOrder;
    }

    public void setAvgGamesPerOrder(Integer avgGamesPerOrder) {
        this.avgGamesPerOrder = avgGamesPerOrder;
    }
}
