package com.example.onlineShop.model.repositories;

import com.example.onlineShop.model.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * Репозиторий для работы с пользователями
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    /**
     * Вывод всех пользователей
     *
     * @param pageable пагинация результатов
     * @return список всех пользователей
     */
    @EntityGraph(attributePaths = "roles")
    Page<User> findAll(Pageable pageable);

    /**
     * Поиск по электронной почте
     *
     * @param email электронная почта
     * @return искомый пользователь
     */
    @EntityGraph(attributePaths = "roles")
    User findByEmail(String email);

    /**
     * Поиск пользователя
     *
     * @param searchType
     * @param text
     * @param pageable
     * @return страница с пользователем, удовлетворяющим запрос
     */
    @EntityGraph(attributePaths = "roles")
    @Query("SELECT user FROM User user WHERE " +
            "(CASE " +
            " WHEN :searchType = 'name' THEN UPPER(user.name) " +
            "WHEN :searchType = 'lastName' THEN UPPER(user.lastName) " +
            "ELSE UPPER(user.email) " +
            "END)" +
            "LIKE UPPER(CONCAT('%',:text,'%'))")
    Page<User> searchUser(Object searchType, String text, Pageable pageable);
}
