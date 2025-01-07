package com.example.onlineShop.repositories;

import com.example.onlineShop.model.entities.ClientOrderHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;
//todo написать сервисы и контроллер
/**
 * Репозиторий для работы с историей заказов пользователя
 */
public interface ClientOrderHistoryRepository extends JpaRepository<ClientOrderHistory, Long> {
    /**
     * Просмотр истории заказов по электронной почте пользователя
     *
     * @param email    электронная почта пользователя
     * @param pageable пагинация результатов
     * @return страница истории заказов пользователя
     */
    Page<ClientOrderHistory> findByEmail(@RequestParam("email") String email, Pageable pageable);
}
