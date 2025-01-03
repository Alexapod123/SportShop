package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Заказ
 */
@Entity
@Table(name = "ORDER")
@Data
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
    @Column(name = "ORDER DATE")
    private LocalDate dateOrder;

    /**
     * Id товаров, добавленных в заказ
     */
    @Column(name = "PRODUCT ID")
    private ArrayList<Long> productsId;

    /**
     * Конструктор с параметрами
     * @param clientName имя покупателя
     * @param clientEmail Электронная почта покупателя
     * @param deliveryAddress адрес доставки
     * @param dateOrder дата заказа
     * @param productsId список id заказанных товаров
     */
    public Order(String clientName, String clientEmail, String deliveryAddress, LocalDate dateOrder, ArrayList<Long> productsId) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.deliveryAddress = deliveryAddress;
        this.dateOrder = dateOrder;
        productsId = new ArrayList<>();
    }

    /***
     * Конструктор без параметров
     */
    public Order(){ }
}
