package com.example.onlineShop.model.entities;

import org.springframework.security.core.GrantedAuthority;

/**
 * Роль пользователя
 */
public enum Role implements GrantedAuthority {
    CLIENT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
