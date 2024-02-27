package com.example.gameshop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "game_is_of_category", schema = "gameshop")
public class GameIsOfCategory {
    @Id
    @Column(name = "category_id")
    private Integer categoryId;

    @Id
    @Column(name = "game_id")
    private Integer gameId;

    public Integer getCategoryId() {
        return this.categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getGameId() {
        return this.gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }
}
