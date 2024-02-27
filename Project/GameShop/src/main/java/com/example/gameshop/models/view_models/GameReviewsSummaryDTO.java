package com.example.gameshop.models.view_models;

import org.hibernate.annotations.Immutable;

import java.time.LocalDate;
@Immutable
public class GameReviewsSummaryDTO {
    private Long gameId;
    private String title;
    private Double rating;
    private String text;
    private LocalDate datePosted;

    public Long getGameId() {
        return this.gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getRating() {
        return this.rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getText() {
        return this.text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDatePosted() {
        return this.datePosted;
    }

    public void setDatePosted(LocalDate datePosted) {
        this.datePosted = datePosted;
    }
}
