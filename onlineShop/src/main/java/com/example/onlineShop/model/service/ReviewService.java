package com.example.onlineShop.model.service;

import com.example.onlineShop.model.entities.Review;
import com.example.onlineShop.model.requestEnt.ReviewRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.List;

/**
 * Интерфейс сервиса для работы с отзывами
 */
public interface ReviewService {

    Page<Review> findByProductId(Long productId, Pageable pageable);

    Page<Review> findByUserEmail(String userEmail, Pageable pageable);

    void addReview(String userEmail, ReviewRequest reviewRequest);
}
