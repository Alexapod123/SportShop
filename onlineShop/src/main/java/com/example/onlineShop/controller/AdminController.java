package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.requestEnt.ProductRequest;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.model.responseEnt.UserResponse;
import com.example.onlineShop.model.service.AdminService;
import com.example.onlineShop.model.utility.UtilController;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.ADMIN)
@PreAuthorize("hasAuthority('ADMIN')")
public class AdminController {
    @Autowired
    private final AdminService adminService;
    @Autowired
    private final UtilController utilController;

    @GetMapping("/products")
    public String getProducts(Model model, Pageable pageable) {
        utilController.addPagination(model, adminService.getProducts(pageable));
        return Page.ADMIN_PRODUCTS;
    }

    @GetMapping("/products/search")
    public String searchProduct(SearchRequest request, Pageable pageable, Model model) {
        utilController.addPagination(request, model, adminService.searchProducts(request, pageable));
        return Page.ADMIN_PRODUCTS;
    }

    @GetMapping("/users")
    public String getUsers(Model model, Pageable pageable) {
        utilController.addPagination(model, adminService.getUsers(pageable));
        return Page.ADMIN_ALL_USERS;
    }

    @GetMapping("/users/search")
    public String searchUser(SearchRequest request, Model model, Pageable pageable) {
        utilController.addPagination(request, model, adminService.searchUsers(request, pageable));
        return Page.ADMIN_ALL_USERS;
    }

    @GetMapping("/order/{orderId}")
    public String getOrder(@PathVariable Long orderId, Model model) {
        model.addAttribute("order", adminService.getOrder(orderId));
        return Page.ORDER;
    }

    @GetMapping("/order/search")
    public String searchOrders(SearchRequest request, Model model, Pageable pageable) {
        utilController.addPagination(request, model, adminService.searchOrders(request, pageable));
        return Page.ORDERS;
    }

    @GetMapping("/product/{productId}")
    public String getProductById(@PathVariable Long productId, Model model) {
        model.addAttribute("product", adminService.findProductById(productId));
        return Page.ADMIN_PRODUCTS_UPDATE;
    }

    @PostMapping("/product/add")
    public String editProduct(@Valid ProductRequest requestProduct, BindingResult bindingResult, Model model,
                              @RequestParam("file") MultipartFile multipartFile,
                              RedirectAttributes redirectAttributes) {
        if (utilController.checkInputs(bindingResult, model, "product", requestProduct)) {
            return Page.ADMIN_PRODUCTS_UPDATE;
        }
        return utilController.setAlertMsg(redirectAttributes, "/admin/products", adminService.addProduct(requestProduct, multipartFile));

    }

    @GetMapping("/user/{userId}")
    public String getUserById(@PathVariable Long userId, Model model, Pageable pageable) {
        UserResponse userResponse = adminService.getUserById(userId, pageable);
        model.addAttribute("user", userResponse.getUser());
        utilController.addPagination(model, userResponse.getOrders());
        return Page.ADMIN_USER_INFO;
    }


}
