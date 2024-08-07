package com.example.orderservice.service;

import com.example.orderservice.model.Order;
import org.aspectj.weaver.ast.Or;

import java.util.List;

public interface OrderService {
    List<Order> getAllOrders();
    Integer getCountOfOrders();
    Order createOrder(Order order);
    Order getOrderById(Long id);
    Order createOrderAfterValidating(Order order);
}
