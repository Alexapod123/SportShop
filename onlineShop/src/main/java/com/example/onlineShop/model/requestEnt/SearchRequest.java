package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.model.entities.Category;
import lombok.Data;

/**
 * Запрос на поиск товара по фильтру
 */
@Data
public class SearchRequest {
    private Category category;
    private Double price;
    private String nameProduct;
}
