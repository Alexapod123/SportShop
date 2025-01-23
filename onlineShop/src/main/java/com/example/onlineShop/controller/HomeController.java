package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Возврат домашней страницы
 */
@Controller
public class HomeController {
    public String home(){
        return Page.HOME;
    }
}
