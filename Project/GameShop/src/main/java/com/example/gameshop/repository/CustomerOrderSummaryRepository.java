package com.example.gameshop.repository;

import com.example.gameshop.models.view_models.CustomerOrderSummary;

import java.util.List;

public interface CustomerOrderSummaryRepository {
    List<CustomerOrderSummary> getOrderSummary();
}
