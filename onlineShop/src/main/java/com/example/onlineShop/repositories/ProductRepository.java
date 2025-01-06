package com.example.onlineShop.repositories;

import com.example.onlineShop.model.entities.Category;
import com.example.onlineShop.model.entities.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Репозиторий товаров
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    /**
     * Поиск по id
     *
     * @param productsId id
     * @return Товар с нужным id
     */
    List<Product> findById(@Param("productId") List<Long> productsId);

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
            "(CASE" +
            "WHEN :searchType = 'productName' THEN UPPER(product.productName)" +
            "WHEN :searchType = 'category' THEN UPPER(product.category)" +
            "END)" +
            "LIKE UPPER(CONCAT('%',:text,'%')) " +
            "ORDER BY product.price ASC")
    Page<Product> searchProducts(String searchType, String text, Pageable pageable);

    /**
     * Поиск по цене
     *
     * @param priceMin минимальная цена
     * @param priceMax максимальная цена
     * @param pageable пагинация результатов
     * @return страница с товарами
     */
    @Query("SELECT product FROM Product product WHERE" +
            "WHERE (coalesce(:priceMin, null) IS NULL OR perfume.price BETWEEN :priceMin AND :priceMax)" +
            "ORDER BY perfume.price ASC")
    Page<Product> getProductsByPrice(Double priceMin, Double priceMax, Pageable pageable);
}
