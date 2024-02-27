package com.example.gameshop.repository;

import com.example.gameshop.models.Game;
import com.example.gameshop.models.Order;
import com.example.gameshop.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.Set;


public interface OrderRepository extends JpaRepository<Order, Integer> {
    Optional<Order> findByUserAndPaymentStatusIsFalse(User customerId);
}
