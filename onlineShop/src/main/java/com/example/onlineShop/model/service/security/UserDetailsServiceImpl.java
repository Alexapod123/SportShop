package com.example.onlineShop.model.service.security;

import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Получение информации о пользователе для его создания
 */
@Service("userDetailsServiceImpl")
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {
    UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = repository.findByEmail(email);
        if (user.equals(null)){
            throw new UsernameNotFoundException("Sorry, user not found!");
        }
        return UserPrincipal.createUser(user);
    }
}
