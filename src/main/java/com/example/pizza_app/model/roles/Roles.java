package com.example.pizza_app.model.roles;

import com.example.pizza_app.model.User;
import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Entity
@Data
public class Roles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String name;

//    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<>();

    public Roles() {
    }

    public Roles(String name) {
        if (name.equals("ADMIN")) {
            this.id = 1L;
        }
        else if (name.equals("USER")){
            this.id = 2L;
        }

        this.name = name;
    }
}
