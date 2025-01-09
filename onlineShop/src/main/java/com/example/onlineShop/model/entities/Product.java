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
    @Column(name = "id")
    private Long id;

    /**
     * Наименование товара
     */
    @Column(name = "name_product", nullable = false)
    private String nameProduct;

    /***
     * Категория товара
     */
    @Column(name = "category", nullable = false)
    private Category category;

    /**
     * Описание товара
     */
    @Column(name = "description", nullable = false)
    private String description;

    /**
     * Цена товара
     */
    @Column(name = "price", nullable = false)
    private Double price;

    /***
     * Количество товара, доступного к заказу
     */
    @Column(name = "amount", nullable = false)
    private int amount;


    /**
     * Путь к изображению товара
     */
    @Column(name = "image", nullable = false)
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
