package com.example.onlineShop.model.responseEnt;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.domain.Page;

/**
 * Инфо пользователя
 */
@Data
@AllArgsConstructor
public class UserResponse {
    private User user;

    private Page<Order> orders;
}
