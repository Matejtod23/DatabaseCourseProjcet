package com.example.gameshop.services;

import com.example.gameshop.models.Game;
import com.example.gameshop.models.Order;

import java.util.Set;

public interface OrderService {
    Order updateOrder(Order o, Game g);

    void clearGames(Order order);

    void confirmPayout(Order order);
}
