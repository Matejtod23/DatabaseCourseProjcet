package com.example.gameshop.services.Impl;

import com.example.gameshop.models.Game;
import com.example.gameshop.models.Order;
import com.example.gameshop.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class OrderService implements com.example.gameshop.services.OrderService {

    private final OrderRepository orderRepository;

    @Override
    public Order updateOrder(Order o ,Game g) {
        o.getGames().add(g);
        o.setTotalAmount(o.getTotalAmount() + g.getPrice());
        orderRepository.save(o);
        return o;
    }

    @Override
    public void clearGames(Order order) {
        order.getGames().clear();
        order.setTotalAmount(0);
        orderRepository.save(order);
    }

    @Override
    public void confirmPayout(Order order) {
        order.setPaymentStatus(true);
        orderRepository.save(order);
    }
}
