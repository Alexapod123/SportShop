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
    @Column(name = "products")
    @ManyToMany
    private ArrayList<Product> products = new ArrayList<>();

    /**
     * Сумма заказа
     */
    @Column(name = "sum")
    private Double totalSum;

    @ManyToOne
    private User user;

//    /**
//     * Конструктор с параметрами
//     *
//     * @param clientName      имя покупателя
//     * @param clientEmail     Электронная почта покупателя
//     * @param deliveryAddress адрес доставки
//     * @param dateOrder       дата заказа
//     * @param products        список id заказанных товаров
//     * @param totalSum        Сумма заказа
//     */
//    public Order(String clientName, String clientEmail, String deliveryAddress, LocalDateTime dateOrder, ArrayList<Product> products, Double totalSum) {
//        this.clientName = clientName;
//        this.clientEmail = clientEmail;
//        this.deliveryAddress = deliveryAddress;
//        this.dateOrder = dateOrder;
//        products = new ArrayList<>();
//        this.totalSum = totalSum;
//    }
}
