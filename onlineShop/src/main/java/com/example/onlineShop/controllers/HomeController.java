package com.example.onlineShop.controllers;

import com.example.onlineShop.constants.Page;
import org.springframework.stereotype.Controller;
//todo добавить путь
@Controller
public class HomeController {
    public String home(){
        return Page.HOME;
    }
}
