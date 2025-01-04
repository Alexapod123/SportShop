package com.example.onlineShop.model.responseEnt;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Ответ администратора
 */
@Data
@AllArgsConstructor
public class AdminResponse {
    private String response;

    private  String textMessage;
}
