package com.example.onlineShop.model.requestEnt;

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

    @NotBlank(message = )
    @Length(max = 255)
    private String nameProduct;

    @NotBlank(message = )
    @Length(max = 255)
    private Category category;

    @NotBlank(message = )
    @Length(max = 800)
    private String description;

    @NotBlank(message = )
    @Min(value = 1, message = )
    private double price;

    @NotBlank(message = )
    @Min(value = 1, message = )
    private int amount;

    private String pathToImg;

}
