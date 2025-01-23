package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.requestEnt.UserRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;
import com.example.onlineShop.model.service.RegistrationService;
import com.example.onlineShop.controller.utility.UtilController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Контроллер для регистрации
 */
@Controller
@RequiredArgsConstructor
@RequestMapping(Path.REGISTRATION)
public class RegistrationController {

    private RegistrationService registrationService;
    @Autowired
    private UtilController utilController;

    private AdminResponse adminResponse;

    @GetMapping()
    public String registration() {
        return Page.REGISTRATION;
    }

    @PostMapping
    public String registration(@RequestParam("captcha-response") String captchaResponse, @Valid UserRequest userRequest,
                               BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               Model model) {
        if (utilController.checkInputs(bindingResult, model, "user", userRequest)) {
            return Page.REGISTRATION;
        }
        adminResponse = registrationService.registration(captchaResponse, userRequest);
        if (utilController.checkInput(model, adminResponse, "user", userRequest)) {
            return Page.REGISTRATION;
        }
        return utilController.setFlashMsg(redirectAttributes, Path.LOGIN, adminResponse);
    }
}
