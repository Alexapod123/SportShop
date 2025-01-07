package com.example.onlineShop.service;

import com.example.onlineShop.model.entities.Review;
import com.example.onlineShop.model.requestEnt.ReviewRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.parameters.P;

import java.util.List;


public interface ReviewService {

    Page<Review> findByProductId(Long productId, Pageable pageable);

    Page<Review> findByUserEmail(String userEmail, Pageable pageable);

    void addReview(String userEmail, ReviewRequest reviewRequest);
}
