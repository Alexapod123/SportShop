package com.example.onlineShop.model.requestEnt;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * Формирование заказа
 */
@Data
public class OrderRequest {
    private Long id;

    private Double totalSum;

    private LocalDateTime dateOrder = LocalDateTime.now();

    @NotBlank(message = )
    private String name;

    @NotBlank(message = )
    private String lastname;

    @NotBlank(message = )
    private String email;

    @NotBlank(message = )
    private String address;

}
