package com.example.onlineShop.service;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User getAuthenticated();
    Page<Order> searchOrdersByUser(SearchRequest searchRequest, Pageable pageable);

}
