package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.USER)
public class UserController {
    @Autowired
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
