package com.example.pizza_app.model;

import com.example.pizza_app.model.roles.Roles;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, updatable = false, nullable = false)
    private String username;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(length = 3000)
    private String password;
    @Column(nullable = false)
    private String address;

    @ElementCollection(targetClass = Roles.class)
    @CollectionTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Roles> roles = new HashSet<>();
    @Column(nullable = false)
    private int phoneNumber;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userId", orphanRemoval = true)
    private List<Order> orderList;

    public User() {
    }




}
