package com.example.pizza_app.model;

import com.example.pizza_app.model.status.Status;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private User userId;
    private double sumCost;

    @JsonFormat(pattern = "yyyy-mm-dd HH:mm:ss")
    @Column(updatable = false)
    private LocalDateTime orderDate;

    private String status;
    private String payment;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItem item;

    public Order() {
    }

    @PrePersist
    protected void onCreate() {
        this.orderDate = LocalDateTime.now();
    }
}
