package com.example.onlineShop.actuator;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

/**
 * Кастомизированная настройка отслеживания производительности
 */
@Endpoint(id = "myCustomActuator")
public class MyCustomActuator {
    @ReadOperation
    public CustomResponse customMethod() {
        return new CustomResponse("My text!", 1);
    }
    @AllArgsConstructor
    @Data
    public static class CustomResponse {
        private String message;
        private int number;

    }

}
