package com.example.onlineShop.model.service.impl;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.OrderRequest;
import com.example.onlineShop.model.repositories.OrderRepository;
import com.example.onlineShop.model.service.OrderService;
import com.example.onlineShop.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

/**
 * Сервис для работы с заказами
 */
@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    @Autowired
    private  final UserService userService;
    @Autowired
    private final OrderRepository orderRepository;
    @Autowired
    private final ModelMapper mapper;

    @Override
    public Order findOrderById(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public Page<Order> getByUser(Pageable pageable) {
        User user = userService.getAuthenticated();
        return orderRepository.getByUserId(user.getId(), pageable);
    }

    @Override
    @Transactional
    public Long postOrder(User user, OrderRequest orderRequest) {
        Order order = mapper.map(orderRequest, Order.class);
        order.setUser(user);
        order.getProducts().addAll(user.getProducts());
        orderRepository.save(order);
        user.getProducts().clear();
        return order.getId();
    }
}
