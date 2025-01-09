package com.example.onlineShop.controllers;

import com.example.onlineShop.constants.Page;
import com.example.onlineShop.constants.Path;
import com.example.onlineShop.model.requestEnt.ReviewRequest;
import com.example.onlineShop.service.ReviewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.REVIEW)
public class ReviewController {
    @Autowired
    private final ReviewService reviewService;

    @GetMapping("/{productId}")
    public String getReviewByProductId(@PathVariable Long productId, Model model, Pageable pageable){
        model.addAttribute("review", reviewService.findByProductId(productId, pageable));
        return Page.REVIEW;
    }

    @GetMapping("/{userEmail}")
    public String getReviewsByUserEmail(@RequestParam String userEmail, Model model, Pageable pageable){
        model.addAttribute("review", reviewService.findByUserEmail(userEmail, pageable));
        return Page.REVIEW;
    }

    @PostMapping("/add")
    public String addReview(@Valid ReviewRequest reviewRequest, String userEmail){
        reviewService.addReview(userEmail, reviewRequest);
        return Page.REVIEW;
    }
}
