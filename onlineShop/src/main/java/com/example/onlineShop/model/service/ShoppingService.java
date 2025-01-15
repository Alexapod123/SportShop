package com.example.onlineShop.model.service;

import com.example.onlineShop.model.entities.Product;

import java.util.List;

/**
 * Интерфейс сервиса корзины товаров
 */
public interface ShoppingService {
    List<Product> getProductInCart();

    void addProductInCart(Long productId);

    void removeProductFromCart(Long productId);
}
