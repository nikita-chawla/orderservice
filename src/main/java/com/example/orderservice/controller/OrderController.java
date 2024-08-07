package com.example.orderservice.controller;

import com.example.orderservice.logging.LogUserRequest;
import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;
import com.example.orderservice.model.User;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping
    @LogUserRequest
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    @GetMapping("/count")
    @LogUserRequest
    public Integer getCountOfOrders() {
        return orderService.getCountOfOrders();
    }

    @PostMapping
    @LogUserRequest
    public Order createOrder(@RequestBody Order order) {
       return orderService.createOrderAfterValidating(order);
    }

    @GetMapping("/{id}")
    @LogUserRequest
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }
}
