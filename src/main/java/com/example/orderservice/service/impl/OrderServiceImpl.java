package com.example.orderservice.service.impl;

import com.example.orderservice.model.Order;
import com.example.orderservice.model.Product;
import com.example.orderservice.model.User;
import com.example.orderservice.repository.OrderRepository;
import com.example.orderservice.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Order createOrderAfterValidating(Order order) {
        User user = restTemplate.getForObject("http://localhost:8081/users/" + order.getUserId(), User.class);
        Product product = restTemplate.getForObject("http://localhost:8082/products/" + order.getProductId(), Product.class);
        if (user != null && product != null) {
            return createOrder(order);
        } else {
            throw new RuntimeException("Invalid user or product ID");
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Integer getCountOfOrders() {
        return orderRepository.findAll().size();
    }

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id).orElse(null);
    }
}
