package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

/**
 * История заказов покупателя
 */
@Entity
@Table(name = "BUYER ORDER HISTORY")
@Data
public class BuyerOrderHistory {
    /**
     * Уникальный id записи в истории
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
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
     * Дата заказа
     */
    @Column(name = "ORDER DATE")
    private LocalDate dateOrder;

    /**
     * Название товара
     */
    @Column(name = "PRODUCT NAME")
    private String nameProduct;

    /**
     * Путь к изображению товара
     */
    @Column(name = "IMAGE")
    private String pathToImg;

    /**
     * Конструктор с параметрами
     * @param clientName имя покупателя
     * @param clientEmail электронная почта покупателя
     * @param dateOrder дата заказа
     * @param nameProduct название товара
     * @param pathToImg путь к изображению товара
     */
    public BuyerOrderHistory(String clientName, String clientEmail, LocalDate dateOrder, String nameProduct, String pathToImg) {
        this.clientName = clientName;
        this.clientEmail = clientEmail;
        this.dateOrder = dateOrder;
        this.nameProduct = nameProduct;
        this.pathToImg = pathToImg;
    }

    /**
     * Конструктор без параметров
     */
    public BuyerOrderHistory(){}
}
