package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.model.constants.ErrorMsg;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = ErrorMsg.INVALID_VALUE)
    private Double rating;

    private Optional<String> textReview;

    @NotBlank(message = ErrorMsg.EMPTY_EMAIL)
    public String userEmail;

}
