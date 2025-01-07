package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.constants.ErrorMsg;
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

    @NotBlank(message = ErrorMsg.EMPTY_NAME)
    private String name;

    @NotBlank(message = ErrorMsg.EMPTY_LAST_NAME)
    private String lastname;

    @NotBlank(message = ErrorMsg.EMPTY_EMAIL)
    private String email;

    @NotBlank(message = ErrorMsg.ADDRESS_EMPTY)
    private String address;

}
