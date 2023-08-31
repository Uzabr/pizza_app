package com.example.pizza_app.model;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;

@Entity
@Getter
@Setter
@ToString
@RequiredArgsConstructor
@AllArgsConstructor
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
}
