package com.example.onlineShop.service;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.Product;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.ProductRequest;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;
import com.example.onlineShop.model.responseEnt.UserResponse;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * Интерфейс сервиса для административных задач
 */
public interface AdminService {
    Page<Product> getProducts(Pageable pageable);

    Page<Product> searchProducts(SearchRequest searchRequest, Pageable pageable);

    Page<User> getUsers(Pageable pageable);

    Page<User> searchUsers(SearchRequest request, Pageable pageable);

    Order getOrder(Long orderId);

    Page<Order> searchOrders(SearchRequest request, Pageable pageable);

    Product findProductById(Long productId);

    AdminResponse editProduct(ProductRequest productRequest, MultipartFile multipartFile);

    AdminResponse addProduct(ProductRequest productRequest, MultipartFile multipartFile);

    UserResponse getUserById(Long userId, Pageable pageable);

}
