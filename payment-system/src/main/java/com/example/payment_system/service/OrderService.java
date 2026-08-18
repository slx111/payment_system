package com.example.payment_system.service;

import com.example.payment_system.entity.Order;
import com.example.payment_system.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public boolean createOrder(Integer userId, java.math.BigDecimal amount) {
        Order order = new Order();
        order.setUserId(userId);
        order.setAmount(amount);
        return orderMapper.insert(order) > 0;
    }

    public List<Order> listOrders(Integer userId) {
        return orderMapper.findByUserId(userId);
    }
}
