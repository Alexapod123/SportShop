package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {
    /**
     * Уникальный id пользователя
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Имя пользователя
     */
    @Column(name = "name", nullable = false)
    private String name;

    /**
     * Фамилия пользователя
     */
    @Column(name = "last_name", nullable = false)
    private String lastName;

    /**
     * Электронная почта пользователя
     */
    @Column(name = "email", nullable = false)
    private String email;

    /**
     * Пароль пользователя
     */
    @Column(name = "password", nullable = false)
    private String password;

    /**
     * Почтовый адрес
     */
    @Column(name = "address")
    private String address;

    /**
     * Роль пользователя
     */
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "userRole", joinColumns = @JoinColumn(name = "userId"))
    @Enumerated(EnumType.STRING)
    private Set<Role> role;

    @ManyToMany
    private List<Product> products;

}
