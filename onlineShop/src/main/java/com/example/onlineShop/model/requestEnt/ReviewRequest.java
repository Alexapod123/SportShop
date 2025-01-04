package com.example.onlineShop.model.requestEnt;

import lombok.Data;

import java.util.Date;
import java.util.Optional;

/**
 * Запрос на добавление отзыва
 */
@Data
public class ReviewRequest {
    private Date date;

    private Long productId;

    private Double rating;

    private Optional<String> textReview;

}
