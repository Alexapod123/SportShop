package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Товар в БД
 */

@Entity
@Table(name = "Product")
@Data
@NoArgsConstructor
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
    @Column(name = "NAME", nullable = false)
    private String nameProduct;

    /***
     * Категория товара
     */
    @Column(name = "CATEGORY", nullable = false)
    private Category category;

    /**
     * Описание товара
     */
    @Column(name = "DESCRIPTION", nullable = false)
    private String description;

    /**
     * Цена товара
     */
    @Column(name = "PRICE", nullable = false)
    private Double price;

    /***
     * Количество товара, доступного к заказу
     */
    @Column(name = "AMOUNT", nullable = false)
    private int amount;


    /**
     * Путь к изображению товара
     */
    @Column(name = "IMAGE", nullable = false)
    private String pathToImg;

    /**
     * Конструктор с параметрами
     *
     * @param nameProduct название продукта
     * @param category    категория
     * @param description описание
     * @param price       цена
     * @param amount      количество в наличии
     * @param pathToImg   путь к изображению
     */
    public Product(String nameProduct, Category category, String description, Double price, int amount, String pathToImg) {
        this.nameProduct = nameProduct;
        this.category = category;
        this.description = description;
        this.price = price;
        this.amount = amount;
        this.pathToImg = pathToImg;
    }
}
