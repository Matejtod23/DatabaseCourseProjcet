package com.example.gameshop.models;

import jakarta.persistence.*;

@Entity
@Table(name = "publisher", schema = "gameshop")
public class Publisher {
    @Id
    @Column(name = "publisher_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer publisherId;

    @Column(name = "name")
    private String name;

    @Column(name = "country")
    private String country;

    public Publisher(String name, String country) {
        this.name = name;
        this.country = country;
    }

    public Publisher() {
    }

    public Integer getPublisherId() {
        return this.publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
