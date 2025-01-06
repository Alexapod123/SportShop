package com.example.onlineShop.service.impl;

import com.example.onlineShop.model.entities.Product;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.repositories.ProductRepository;
import com.example.onlineShop.service.ShoppingService;
import com.example.onlineShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ShoppingServiceImpl implements ShoppingService {
    private final UserService userService;
    private final ProductRepository productRepository;
    @Override
    public List<Product> getProductInCart() {
        User user = userService.getAuthenticated();
        return user.getProducts();
    }

    @Override
    @Transactional
    public void addProductInCart(Long productId) {
        User user = userService.getAuthenticated();
        Product product = productRepository.getReferenceById(productId);
        user.getProducts().add(product);

    }

    @Override
    @Transactional
    public void removeProductFromCart(Long productId) {
        User user = userService.getAuthenticated();
        Product product = productRepository.getReferenceById(productId);
        user.getProducts().remove(product);
    }
}
