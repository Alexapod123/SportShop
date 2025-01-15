package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.OrderRequest;
import com.example.onlineShop.model.service.OrderService;
import com.example.onlineShop.model.service.UserService;
import com.example.onlineShop.model.utility.UtilController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.ORDER)
public class OrderController {
    @Autowired
    private final OrderService orderService;
    @Autowired
    private final UtilController utilController;
    @Autowired
    private final UserService userService;

    @GetMapping("/{orderId}")
    public String getOrderById(@PathVariable Long orderId, Model model){
        model.addAttribute("order", orderService.findOrderById(orderId));
        return Page.ORDER;
    }

    @GetMapping("/user/orders")
    public String getOrderByUser(Model model, Pageable pageable){
        utilController.addPagination(model, orderService.getByUser(pageable));
        return Page.ORDERS;
    }

    @PostMapping
    public String postOrder(@Valid OrderRequest orderRequest, BindingResult bindingResult, Model model){
        User user = userService.getAuthenticated();
        if (utilController.checkInputs(bindingResult, model, "products", user.getProducts())) {
            return Page.ORDERING;
        }
        model.addAttribute("orderId", orderService.postOrder(user, orderRequest));
        return Page.ORDER_END;
    }

}
