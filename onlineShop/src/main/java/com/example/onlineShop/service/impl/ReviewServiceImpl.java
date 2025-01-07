package com.example.onlineShop.service.impl;

import com.example.onlineShop.model.entities.Review;
import com.example.onlineShop.model.requestEnt.ReviewRequest;
import com.example.onlineShop.repositories.ReviewRepository;
import com.example.onlineShop.service.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    @Override
    public Page<Review> findByProductId(Long productId, Pageable pageable) {
        return reviewRepository.findByProductId(productId, pageable);
    }

    @Override
    public Page<Review> findByUserEmail(String userEmail, Pageable pageable) {
        return reviewRepository.findByUserEmail(userEmail, pageable);
    }

    @Override
    public void addReview(String userEmail, ReviewRequest reviewRequest) {
        Review review = new Review();
        review.setProductId(reviewRequest.getProductId());
        review.setRating(reviewRequest.getRating());
        review.setClientEmail(userEmail);
        if (reviewRequest.getTextReview().isPresent()){
            review.setTextReview(reviewRequest.getTextReview().map(t -> t.toString())
                    .orElse(null));
        }
        review.setDateReview(Date.valueOf(LocalDate.now()));
        reviewRepository.save(review);
    }
}
