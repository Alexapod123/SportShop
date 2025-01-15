package com.example.onlineShop.model.service.impl;

import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.repositories.OrderRepository;
import com.example.onlineShop.model.repositories.UserRepository;
import com.example.onlineShop.model.service.UserService;
import com.example.onlineShop.model.service.security.UserPrincipal;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    private final UserRepository userRepository;
    @Autowired
    private final OrderRepository orderRepository;

    @Override
    public User getAuthenticated() {
        UserPrincipal userPrincipal = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return userRepository.findByEmail(userPrincipal.getEmail());
    }

//    @Override
//    public Page<Order> searchOrdersByUser(SearchRequest searchRequest, Pageable pageable) {
//        User user = getAuthenticated();
//        return orderRepository.searchUserOrder(user.getId(), searchRequest.getSearchType(), searchRequest.getText(), pageable);
//    }
}
