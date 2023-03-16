package com.mahmutcelik.bakcend.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String domain;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private Integer experience;
    @Column(nullable = false)
    private String name;
}