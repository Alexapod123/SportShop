package com.example.onlineShop.model.entities;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    CLIENT, ADMIN;

    @Override
    public String getAuthority() {
        return name();
    }
}
