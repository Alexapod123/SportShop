package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.constants.ErrorMsg;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Добавление нового пользователя
 */
@Data
public class UserRequest {
    @NotBlank(message = ErrorMsg.EMPTY_NAME)
    private String name;

    @NotBlank(message = ErrorMsg.EMPTY_LAST_NAME)
    private String lastname;

    @Email(message = ErrorMsg.INVALID_EMAIL)
    @NotBlank(message = ErrorMsg.EMPTY_EMAIL)
    private String email;

    @Size(min = 8, max = 20, message = ErrorMsg.INVALID_PASSWORD)
    @NotBlank(message = ErrorMsg.EMPTY_PASSWORD)
    private String password;
}
