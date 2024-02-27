package com.example.gameshop.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "order", schema = "gameshop")
public class Order {
    @Id
    @Column(name = "order_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "order_date")
    private LocalDate orderDate;

    @Column(name = "total_amount")
    private Integer totalAmount;

    @Column(name = "payment_status")
    private Boolean paymentStatus;

    @OneToOne
    @JoinColumn(name = "customer_id", referencedColumnName = "customer_id")
    private User user;

    @ManyToMany
    @JoinTable(name = "game_is_part_of_order", schema = "gameshop",
            joinColumns = { @JoinColumn(name = "order_id") },
            inverseJoinColumns = { @JoinColumn(name = "game_id") })
    private Set<Game> games = new HashSet<>();

    public Order(LocalDate orderDate, Integer totalAmount, Boolean paymentStatus, User user, Set<Game> games) {
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;
        this.user = user;
        this.games = games;
    }

    public Order() {

    }

    //     @ManyToOne
//    @JoinColumn(name = "publisher_id", referencedColumnName = "publisher_id")
//    private Publisher publisher;

}
