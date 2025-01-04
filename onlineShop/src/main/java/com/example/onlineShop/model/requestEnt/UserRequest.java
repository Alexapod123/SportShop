package com.example.onlineShop.model.requestEnt;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

/**
 * Добавление нового пользователя
 */
@Data
public class UserRequest {
    @NotBlank(message = )
    private String name;

    @NotBlank(message = )
    private String lastname;

    @Email(message = )
    @NotBlank(message = )
    private String email;

    @Size(min = 8, max = 20, message = )
    @NotBlank(message = )
    private String password;
}
