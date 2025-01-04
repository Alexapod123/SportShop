package com.example.onlineShop.model.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * Отзыв
 */
@Entity
@Table(name = "REVIEW")
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
    @Column(name = "id product")
    private Long productId;

    /**
     * Дата отзыва
     */
    @Column(name = "DATA")
    private Date dateReview;

    /**
     * Имя покупателя
     */
    @Column(name = "CLIENT NAME")
    private  String clientName;

    /**
     * Электронная почта покупателя
     */
    @Column(name = "CLIENT EMAIL")
    private String clientEmail;

    /**
     * Оценка товара
     */
    @Column(name = "RATING")
    private Double rating;

    /**
     * Текст отзыва
     */
    @Column(name = "REVIEW")
    private String textReview;

}
