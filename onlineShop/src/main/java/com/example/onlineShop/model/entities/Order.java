package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Заказ
 */
@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    /**
     * Уникальный id заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * Имя покупателя
     */
    @Column(name = "client_name")
    private String clientName;

    /**
     * Электронная почта покупателя
     */
    @Column(name = "client_email")
    private String clientEmail;

    /**
     * Адрес доставки заказа
     */
    @Column(name = "delivery_address")
    private String deliveryAddress;


    /***
     * Дата заказа
     */
    @Column(name = "order_date", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime dateOrder = LocalDateTime.now();

    /**
     * Товары, добавленные в заказ
     */

    @ManyToMany
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * Сумма заказа
     */
    @Column(name = "total_sum")
    private Double totalSum;

    @ManyToOne
    private User user;

}
