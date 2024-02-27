package com.example.gameshop.models.view_models;

import org.hibernate.annotations.Immutable;

@Immutable
public class AvgRatingAndNumRatingDTO {
    private Long gameId;
    private String title;
    private Integer numReviews;
    private Double averageRating;

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

    public Integer getNumReviews() {
        return this.numReviews;
    }

    public void setNumReviews(Integer numReviews) {
        this.numReviews = numReviews;
    }

    public Double getAverageRating() {
        return this.averageRating;
    }

    public void setAverageRating(Double averageRating) {
        this.averageRating = averageRating;
    }
}
