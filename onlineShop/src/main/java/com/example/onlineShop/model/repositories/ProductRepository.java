package com.example.onlineShop.model.repositories;

import com.example.onlineShop.model.entities.Category;
import com.example.onlineShop.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Репозиторий товаров
 */
@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {


    /**
     * Поиск по категории
     *
     * @param category категория
     * @param pageable пагинация результатов
     * @return страница с товарами категории
     */
    Page<Product> findByCategory(@RequestParam("category") Category category, Pageable pageable);

    /**
     * Поиск товаров
     *
     * @param searchType тип поиска
     * @param text       запрос
     * @param pageable   пагинация результатов
     * @return страница с товарами
     */
    @Query("SELECT product FROM Product product WHERE" +
            "(CASE " +
            "   WHEN :searchType = 'nameProduct' THEN UPPER(product.nameProduct) " +
       //     "   WHEN :searchType = 'category' THEN UPPER(category) " +
            "END)" +
            "LIKE UPPER(CONCAT('%',:text,'%')) " +
            "ORDER BY product.price ASC")
    Page<Product> searchProducts(Object searchType, String text, Pageable pageable);

    /**
     * Поиск по цене
     *
     * @param priceMin минимальная цена
     * @param priceMax максимальная цена
     * @param pageable пагинация результатов
     * @return страница с товарами
     */
    @Query("SELECT product FROM Product product " +
            "WHERE (coalesce(:priceMin, null) IS NULL OR product.price BETWEEN :priceMin AND :priceMax)" +
            "ORDER BY product.price ASC")
    Page<Product> getProductsByPrice(Double priceMin, Double priceMax, Pageable pageable);
}
