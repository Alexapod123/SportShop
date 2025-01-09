package com.example.onlineShop.model.requestEnt;

import com.example.onlineShop.model.entities.Category;
import lombok.Data;

import java.util.List;

/**
 * Запрос на поиск товара по фильтру
 */
@Data
public class SearchRequest {
    private List<String> products;
    private Category category;
    private Double price;
    private String nameProduct;
    private Object searchType;
    private String text;
}
