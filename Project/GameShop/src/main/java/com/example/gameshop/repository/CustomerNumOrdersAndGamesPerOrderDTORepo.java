package com.example.gameshop.repository;

import com.example.gameshop.models.view_models.CustomerNumOrdersAndGamesPerOrderDTO;

import java.util.List;

public interface CustomerNumOrdersAndGamesPerOrderDTORepo {
    List<CustomerNumOrdersAndGamesPerOrderDTO> getCustomerInfo();
}
