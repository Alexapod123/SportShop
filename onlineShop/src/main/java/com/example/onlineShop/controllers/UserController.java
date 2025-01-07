package com.example.onlineShop.controllers;

import com.example.onlineShop.constants.Page;
import com.example.onlineShop.constants.Path;
import com.example.onlineShop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.USER)
public class UserController {
    private final UserService userService;

    @GetMapping("/contacts")
    public String contacts() {
        return Page.CONTACTS;
    }

    @GetMapping("/account")
    public String userAcc(Model model){
        model.addAttribute("user", userService.getAuthenticated());
        return Page.USER_ACC;
    }

    @GetMapping("/info")
    public String userInfo(Model model){
        model.addAttribute("user", userService.getAuthenticated());
        return Page.USER_INFO;
    }

}
