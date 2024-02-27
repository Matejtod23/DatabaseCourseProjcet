package com.example.gameshop.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "review", schema = "gameshop")
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reviewId;

    @Column(name = "rating")
    private double rating;

    @Column(name = "text")
    private String text;

    @Column(name = "date_posted")
    private LocalDate datePosted;

    @Column(name = "game_id")
    private Integer gameId;

    @Column(name = "customer_id")
    private Integer customerId;

    public Integer getReviewId() {
        return this.reviewId;
    }

    public void setReviewId(Integer reviewId) {
        this.reviewId = reviewId;
    }

    public double getRating() {
        return this.rating;
    }

    public void setRating(double rating) {
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

    public Integer getGameId() {
        return this.gameId;
    }

    public void setGameId(Integer gameId) {
        this.gameId = gameId;
    }

    public Integer getCustomerId() {
        return this.customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }
}
