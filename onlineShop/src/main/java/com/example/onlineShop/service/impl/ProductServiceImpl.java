package com.example.onlineShop.service.impl;

import com.example.onlineShop.model.entities.Category;
import com.example.onlineShop.model.entities.Product;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.repositories.ProductRepository;
import com.example.onlineShop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, //todo добавить ошибку ));
    }

    @Override
    public Page<Product> findProductByCategory(Category category, Pageable pageable) {
        return productRepository.findByCategory(category, pageable);
    }

    @Override
    public Page<Product> searchProducts(SearchRequest searchRequest, Pageable pageable) {
        return productRepository.searchProducts(searchRequest.getSearchType(), searchRequest.getText(), pageable);
    }

    @Override
    public Page<Product> getProductsByPrice(Double priceMin, Double priceMax, Pageable pageable) {
        return  productRepository.getProductsByPrice(priceMin, priceMax, pageable);
    }
}
