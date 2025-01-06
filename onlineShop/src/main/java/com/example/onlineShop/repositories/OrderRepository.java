package com.example.onlineShop.repositories;

import com.example.onlineShop.model.entities.Order;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

/**
 * Репозиторий для работы с заказами
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
    /**
     * Просмотр всех заказов
     *
     * @param pageable пагинация результатов
     * @return все заказы
     */
    @EntityGraph(attributePaths = {"products", "user", "user.roles"})
    Page<Order> findAll(Pageable pageable);

    /**
     * Поиск заказа по id
     *
     * @param orderId id заказа
     * @return заказ с нужным id
     */
    @EntityGraph(attributePaths = {"products", "user", "user.roles"})
    Optional<Order> findById(Long orderId);

    /**
     * Поиск заказов пользователя
     *
     * @param userId   id пользователя
     * @param pageable пагинация результатов
     * @return страница с заказами конкретного пользователя
     */
    @EntityGraph(attributePaths = {"products", "user", "user.roles"})
    Page<Order> getByUserId(Long userId, Pageable pageable);

    /**
     * Поиск заказов по имени или электронной почте
     *
     * @param searchType тип поиска
     * @param text       ключевые слова
     * @param pageable   пагинация результатов
     * @return страница с результатами, удовлетворяющими запросу
     */
    @EntityGraph(attributePaths = {"products", "user", "user.roles"})
    @Query("SELECT orders FROM Order orders  WHERE" +
            "(CASE " +
            "WHEN :searchType = 'name' THEN UPPER(orders.name)" +
            "WHEN :searchType = 'lastname' THEN UPPER(orders.lastname)" +
            "ELSE UPPER(orders.email)" +
            "END) " +
            "LIKE UPPER (CONTACT('%',:text, '%'))")
    Page<Order> searchOrder(String searchType, String text, Pageable pageable);

    /**
     * Поиск заказов по имени, электронной почте или id пользователя
     *
     * @param userId     id пользователя
     * @param searchType тип поиска
     * @param text       ключевые слова
     * @param pageable   пагинация результатов
     * @return страница с результатами, удовлетворяющими запросу
     */
    @EntityGraph(attributePaths = {"products", "user", "user.roles"})
    @Query("SELECT orders FROM Order orders " +
            "LEFT JOIN orders.user user " +
            "WHERE user.id = :userId " +
            "AND (CASE " +
            "WHEN :searchType = 'name' THEN UPPER(orders.name)" +
            "WHEN :searchType = 'lastname' THEN UPPER(orders.lastname)" +
            "ELSE UPPER(orders.email)" +
            "END) " +
            "LIKE UPPER (CONTACT('%',:text, '%'))")
    Page<Order> searchUserOrder(Long userId, String searchType, String text, Pageable pageable);
}
