package com.example.onlineShop.model.repositories;

import com.example.onlineShop.model.entities.Review;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
/**
 * Репозиторий для работы с отзывами
 */
@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {
    /**
     * Поиск отзывов по id товара
     * @param pageable пагинация результатов
     * @param productId id товара
     * @return страница с отзывами на конкретный товар
     */
    Page<Review> findByProductId(@Param("productId") Long productId, Pageable pageable);

    /**
     * Поиск отзывов пользователя
     *
     * @param userEmail id пользователя
     * @param pageable  пагинация результатов
     * @return страница с отзывами, оставленными конкретным пользователем
     */
    Page<Review> findByUserEmail(String userEmail, Pageable pageable);

    @Modifying
    @Query("DELETE  FROM Review reviews WHERE productId in: productId ")
    static void deleteAllByProductId(@Param("productId") Long productId) {
    }


}
