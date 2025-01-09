package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Отзыв
 */
@Entity
@Table(name = "review")
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    /**
     * Уникальный id отзыва
     */
    @Column(name = "id")
    private Long id;

    /**
     * Id товара, на который дан отзыв
     */
    @Column(name = "id_product")
    private Long productId;

    /**
     * Дата отзыва
     */
    @Column(name = "data")
    private Date dateReview;

    /**
     * Имя покупателя
     */
    @Column(name = "client_name")
    private  String clientName;

    /**
     * Электронная почта покупателя
     */
    @Column(name = "client_email")
    private String userEmail;

    /**
     * Оценка товара
     */
    @Column(name = "rating")
    private Double rating;

    /**
     * Текст отзыва
     */
    @Column(name = "review")
    private String textReview;

}
