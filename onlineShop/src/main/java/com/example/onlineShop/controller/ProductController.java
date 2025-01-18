package com.example.onlineShop.controller;

import com.example.onlineShop.model.constants.Page;
import com.example.onlineShop.model.constants.Path;
import com.example.onlineShop.model.entities.Category;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.model.service.ProductService;
import com.example.onlineShop.controller.utility.UtilController;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
@RequestMapping(Path.PRODUCT)
public class ProductController {
    @Autowired
    private final ProductService productService;
    @Autowired
    private final UtilController utilController;

    @GetMapping("/{productId}")
    public String getProductById(@PathVariable Long productId, Model model){
        model.addAttribute("product", productService.findProductById(productId));
        return Page.PRODUCT;
    }

    @GetMapping("/{category}")
    public String getProductByCategory(@RequestParam Category category, Model model, Pageable pageable){
        model.addAttribute("products", productService.findProductByCategory(category,pageable));
        return Page.PRODUCTS;
    }

    @GetMapping("/search")
    public String searchProducts(SearchRequest request, Model model, Pageable pageable){
        utilController.addPagination(request, model, productService.searchProducts(request, pageable));
        return Page.PRODUCTS;
    }
//todo добавить путь
    @GetMapping
    public  String getProductsByPrice(SearchRequest request, Model model, Pageable pageable){
    utilController.addPagination(request, model, productService.getProductsByPrice(request.getPrice(), request.getPrice(), pageable));
        return Page.PRODUCTS;
    }
}
