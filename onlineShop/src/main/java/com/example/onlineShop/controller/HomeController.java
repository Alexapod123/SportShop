package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import org.springframework.stereotype.Controller;
//todo добавить путь
@Controller
public class HomeController {
    public String home(){
        return Page.HOME;
    }
}
