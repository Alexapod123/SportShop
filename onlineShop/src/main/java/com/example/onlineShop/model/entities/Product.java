package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

/**
 * Товар в БД
 */

@Entity
@Table(name = "Product")
@Data
public class Product {
    /**
     * Уникальный id для товара
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    /**
     * Наименование товара
     */
    @Column(name = "NAME")
    private String nameProduct;

    /***
     * Категория товара
     */
    @Column(name = "CATEGORY")
    private Category category;

    /**
     * Описание товара
     */
    @Column(name = "DESCRIPTION")
    private String description;

    /**
     * Цена товара
     */
    @Column(name = "PRICE")
    private double price;

    /***
     * Количество товара, доступного к заказу
     */
    @Column(name = "AMOUNT")
    private int amount;


    /**
     * Путь к изображению товара
     */
    @Column(name = "IMAGE")
    private String pathToImg;



}
