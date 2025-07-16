package com.data.session06.service;

import com.data.session06.model.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    Order getOrderById(Long id);
    Order updateOrder(Long id, Order order);
    void deleteOrder(Long id);
    List<Order> getAllOrders();
    List<Order> getOrdersByDate(String date);
}

