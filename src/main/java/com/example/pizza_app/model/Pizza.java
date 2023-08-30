package com.example.pizza_app.model;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;

import java.sql.Types;
import java.util.Date;
import java.util.List;

@Entity
@Data
public class Pizza {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;

    @Column(columnDefinition = "text")
    private String description;
    @Lob
    @JdbcTypeCode(Types.VARBINARY)
    private byte[] image;

    @ManyToOne(fetch = FetchType.EAGER)
    private Category categories;

    @Column(unique = true, nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY)
    private OrderItem item;

    public Pizza() {
    }
}
