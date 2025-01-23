package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.service.ShoppingService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Контроллер для работы с корзиной
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(Path.CART)
public class ShoppingController {
    @Autowired
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

    @PostMapping("/remove")
    public String removeProductFromCart(@RequestParam("productId") Long productId){
        shoppingService.removeProductFromCart(productId);
        return "redirect: " + Path.CART;
    }
}
