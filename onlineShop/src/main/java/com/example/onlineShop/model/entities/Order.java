package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Заказ
 */
@Entity
@Table(name = "ORDER")
@Data
@NoArgsConstructor
public class Order {
    /**
     * Уникальный id заказа
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Имя покупателя
     */
    @Column(name = "CLIENT NAME")
    private String clientName;

    /**
     * Электронная почта покупателя
     */
    @Column(name = "CLIENT EMAIL")
    private String clientEmail;

    /**
     * Адрес доставки заказа
     */
    @Column(name = "DELIVERY ADDRESS")
    private String deliveryAddress;


    /***
     * Дата заказа
     */
    @Column(name = "ORDER DATE", columnDefinition = "timestamp default current_timestamp")
    private LocalDateTime dateOrder = LocalDateTime.now();

    /**
     * Товары, добавленные в заказ
     */
    @Column(name = "PRODUCT ID")
    private ArrayList<Product> products;

    /**
     * Сумма заказа
     */
    @Column(name = "SUM")
    private Double totalSum;

    /**
     * Конструктор с параметрами
     *
     * @param clientName      имя покупателя
     * @param clientEmail     Электронная почта покупателя
     * @param deliveryAddress адрес доставки
     * @param dateOrder       дата заказа
     * @param products        список id заказанных товаров
     * @param totalSum        Сумма заказа
     */
    public Order(String clientName, String clientEmail, String deliveryAddress, LocalDateTime dateOrder, ArrayList<Product> products, Double totalSum) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.deliveryAddress = deliveryAddress;
        this.dateOrder = dateOrder;
        products = new ArrayList<>();
        this.totalSum = totalSum;
    }
}
