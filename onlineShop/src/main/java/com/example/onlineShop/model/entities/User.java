package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

/**
 * Пользователь
 */
@Entity
@Table(name = "USERS")
@Data
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
    @Column(name = "name")
    private String name;

    /**
     * Фамилия пользователя
     */
    @Column(name = "lastname")
    private String lastname;

    /**
     * Электронная почта пользователя
     */
    @Column(name = "email")
    private String email;

    /**
     * Пароль пользователя
     */
    @Column(name = "password")
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

    /**
     * Конструктор без параметров
     */
    User(){}
}
