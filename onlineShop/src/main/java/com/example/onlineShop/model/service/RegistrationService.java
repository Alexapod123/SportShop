package com.example.onlineShop.model.service;

import com.example.onlineShop.model.requestEnt.UserRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;

public interface RegistrationService {

    AdminResponse registration(String captchaResponse, UserRequest userRequest);

}
