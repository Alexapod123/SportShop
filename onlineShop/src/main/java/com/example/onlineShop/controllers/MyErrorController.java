package com.example.onlineShop.controllers;

import com.example.onlineShop.constants.Page;
import com.example.onlineShop.constants.Path;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyErrorController implements ErrorController {
    @RequestMapping(Path.ERROR)
    public String errorProcessing(HttpServletRequest servletRequest, Model model){
        Integer codeStatus = (Integer) servletRequest.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);

        if (codeStatus.equals(HttpStatus.NOT_FOUND.value())){
            model.addAttribute("errorMessage", servletRequest.getAttribute(RequestDispatcher.ERROR_MESSAGE));
            return Page.ERROR_404;
        }
        return Page.ERROR_500;
    }

}
