package com.example.onlineShop.model.responseEnt;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.Set;

/**
 * Проверка пользователя
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CaptchaResponse {
    private boolean success;

    private Set<String> errors;

}
