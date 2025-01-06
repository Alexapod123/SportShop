package com.example.onlineShop.service;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.OrderRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Интерфейс сервиса для работы с заказами
 */
public interface OrderService {
    Order findOrderById(Long orderId);

    Page<Order> getByUser(Pageable pageable);

    Long postOrder(User user, OrderRequest orderRequest);
}
