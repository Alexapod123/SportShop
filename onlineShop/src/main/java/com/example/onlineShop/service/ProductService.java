package com.example.onlineShop.service;

import com.example.onlineShop.model.entities.Category;
import com.example.onlineShop.model.entities.Product;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Интерфейс сервиса товаров
 */
public interface ProductService {
    Product findProductById(Long productId);

    Page<Product> findProductByCategory(Category category, Pageable pageable);

    Page<Product> searchProducts(SearchRequest searchRequest, Pageable pageable);

    Page<Product> getProductsByPrice(Double priceMin, Double priceMax, Pageable pageable);
}
