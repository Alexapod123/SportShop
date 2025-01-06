package com.example.onlineShop.service.impl;

import com.example.onlineShop.model.entities.Order;
import com.example.onlineShop.model.entities.Product;
import com.example.onlineShop.model.entities.User;
import com.example.onlineShop.model.requestEnt.ProductRequest;
import com.example.onlineShop.model.requestEnt.SearchRequest;
import com.example.onlineShop.model.responseEnt.AdminResponse;
import com.example.onlineShop.model.responseEnt.UserResponse;
import com.example.onlineShop.repositories.OrderRepository;
import com.example.onlineShop.repositories.ProductRepository;
import com.example.onlineShop.repositories.UserRepository;
import com.example.onlineShop.service.AdminService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.File;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    @Value("${upload.path}")
    private String uploadPath;

    private final UserRepository userRepository;
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    private final ModelMapper mapper;

    @Override
    public Page<Product> getProducts(Pageable pageable) {
        return productRepository.findAll(pageable);
    }

    @Override
    public Page<Product> searchProducts(SearchRequest searchRequest, Pageable pageable) {
        return productRepository.searchProducts(searchRequest.getSearchType(), searchRequest.getText(), pageable);
    }

    @Override
    public Page<User> getUsers(Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @Override
    public Page<User> searchUsers(SearchRequest request, Pageable pageable) {
        return userRepository.searchUser(request.getSearchType(), request.getText(), pageable);
    }

    @Override
    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, //todo error))

    }

    @Override
    public Page<Order> searchOrders(SearchRequest request, Pageable pageable) {
        return orderRepository.searchOrder(request.getSearchType(), request.getText(), pageable);
    }

    @Override
    public Product findProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, //todo error))
    }

    @Override
    @SneakyThrows
    @Transactional
    public AdminResponse editProduct(ProductRequest productRequest, MultipartFile multipartFile) {
        return saveProduct(productRequest, multipartFile, //todo message)
    }

    @Override
    @SneakyThrows
    @Transactional
    public AdminResponse addProduct(ProductRequest productRequest, MultipartFile multipartFile) {
        return saveProduct(productRequest, multipartFile, //todo message)
    }

    @Override
    public UserResponse getUserById(Long userId, Pageable pageable) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, //todo error))
        Page<Order> orders = orderRepository.getByUserId(userId, pageable);
        return new UserResponse(user, orders);
    }
    @SneakyThrows
    private AdminResponse saveProduct(ProductRequest productRequest, MultipartFile multipartFile, String message){
        Product product = mapper.map(productRequest, Product.class);
        if (multipartFile!=null && !multipartFile.getOriginalFilename().isEmpty()){
            File uploadDir = new File(uploadPath);
            if (uploadDir.exists()){
                uploadDir.mkdir();
            }
            String uuidFile = UUID.randomUUID().toString();
            String resultFileName = uuidFile + "." + multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File(uploadPath + "/" + resultFileName));
            product.setPathToImg(resultFileName);
        }
        productRepository.save(product);
        return new AdminResponse("saved", //todo message)
    }
}
