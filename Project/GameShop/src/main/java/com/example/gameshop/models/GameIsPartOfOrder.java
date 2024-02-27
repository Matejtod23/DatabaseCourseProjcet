package com.example.gameshop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "game_is_part_of_order", schema = "gameshop")
public class GameIsPartOfOrder {
    @Id
    @Column(name = "game_id")
    private Integer gameId;

    @Id
    @Column(name = "order_id")
    private Integer orderId;

    public Integer getGameId() {
        return this.gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getOrderId() {
        return this.orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}
