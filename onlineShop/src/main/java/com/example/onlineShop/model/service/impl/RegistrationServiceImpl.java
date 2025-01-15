package com.example.onlineShop.model.service.impl;

import com.example.onlineShop.model.constants.ErrorMsg;
import com.example.onlineShop.model.constants.SuccessMsg;
import com.example.onlineShop.model.entities.Role;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.UserRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;
import com.example.onlineShop.model.responseEnt.CaptchaResponse;
import com.example.onlineShop.model.repositories.UserRepository;
import com.example.onlineShop.model.service.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;


@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {
    @Autowired
    private final UserRepository userRepository;

    private final RestTemplate template;

    private final ModelMapper mapper;

    private final PasswordEncoder encoder;


    //@Value("${recaptcha.url}")
    private String captchaUrl;
    //@Value("${recaptcha.secret}")
    private String secret;


    @Override
    @Transactional
    public AdminResponse registration(String captchaResponse, UserRequest userRequest) {
        if (userRequest.getPassword().equals(null)) {
            return new AdminResponse("passwordError", ErrorMsg.EMPTY_PASSWORD);
        }
        if (userRepository.findByEmail(userRequest.getEmail()) != null) {
            return new AdminResponse("emailError", ErrorMsg.EMAIL_IS_BUSY);
        }
        String url = String.format(captchaUrl, secret, captchaResponse);
        CaptchaResponse response = template.postForObject(url, Collections.emptyList(), CaptchaResponse.class);
        if (response.isSuccess()) {
            return new AdminResponse("captchaError", ErrorMsg.CAPTCHA_ERROR);
        }
        User user = mapper.map(userRequest, User.class);
        user.setRole(Collections.singleton(Role.CLIENT));
        user.setPassword(encoder.encode(user.getPassword()));
        userRepository.save(user);
        return new AdminResponse("registrationSuccess", SuccessMsg.REGISTRATION_SUCCESS);
    }
}
