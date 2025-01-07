package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.constants.ErrorMsg;
import com.example.onlineShop.model.entities.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * Добавление нового продукта
 */
@Data
public class ProductRequest {
    private Long id;

    @NotBlank(message = ErrorMsg.FILL_IN_THE_FIELD)
    @Length(max = 255)
    private String nameProduct;

    @NotBlank(message = ErrorMsg.FILL_IN_THE_FIELD)
    @Length(max = 255)
    private Category category;

    @NotBlank(message = ErrorMsg.FILL_IN_THE_FIELD)
    @Length(max = 800)
    private String description;

    @NotBlank(message = ErrorMsg.FILL_IN_THE_FIELD)
    @Min(value = 1, message = ErrorMsg.INVALID_VALUE)
    private double price;

    @NotBlank(message = ErrorMsg.FILL_IN_THE_FIELD)
    @Min(value = 1, message = ErrorMsg.INVALID_VALUE)
    private int amount;

    private String pathToImg;

}
