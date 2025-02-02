package com.example.onlineShop.model.service;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Интерфейс сервиса для работы с пользователем
 */
public interface UserService {
    User getAuthenticated();


}
