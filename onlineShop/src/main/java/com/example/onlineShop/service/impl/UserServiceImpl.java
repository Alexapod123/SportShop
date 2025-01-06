package com.example.onlineShop.service.impl;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.repositories.OrderRepository;
import com.example.onlineShop.repositories.UserRepository;
import com.example.onlineShop.service.UserService;
import com.example.onlineShop.service.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final OrderRepository orderRepository;

    @Override
    public User getAuthenticated() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userPrincipal.getEmail());
    }

    @Override
    public Page<Order> searchOrdersByUser(SearchRequest searchRequest, Pageable pageable) {
        User user = getAuthenticated();
        return orderRepository.searchUserOrder(user.getId(), searchRequest.getSearchType(), searchRequest.getText(), pageable);
    }
}
