package com.example.gameshop.models.view_models;

import org.hibernate.annotations.Immutable;

import java.time.LocalDate;
@Immutable
public class GamePublisherInfoDTO {
    private String title;
    private String platform;
    private LocalDate releaseDate;
    private Long price;
    private String publisherName;
    private String publisherCountry;

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlatform() {
        return this.platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Long getPrice() {
        return this.price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getPublisherName() {
        return this.publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherCountry() {
        return this.publisherCountry;
    }

    public void setPublisherCountry(String publisherCountry) {
        this.publisherCountry = publisherCountry;
    }
}
