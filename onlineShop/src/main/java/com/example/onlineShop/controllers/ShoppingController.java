package com.example.onlineShop.controllers;

import com.example.onlineShop.constants.Page;
import com.example.onlineShop.constants.Path;
import com.example.onlineShop.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.CART)
public class ShoppingController {
    private final ShoppingService shoppingService;

    @GetMapping
    public String getProductsInCart(Model model){
        model.addAttribute("products", shoppingService.getProductInCart());
        return Page.CART;
    }

    @PostMapping("/add")
    public String addProductInCart(@RequestParam("productId") Long productId){
        shoppingService.addProductInCart(productId);
        return "redirect: " + Path.CART;
    }

    @PostMapping("/add")
    public String removeProductFromCart(@RequestParam("productId") Long productId){
        shoppingService.removeProductFromCart(productId);
        return "redirect: " + Path.CART;
    }
}
