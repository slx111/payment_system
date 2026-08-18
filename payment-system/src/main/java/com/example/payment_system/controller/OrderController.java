package com.example.payment_system.controller;

import com.example.payment_system.entity.Order;
import com.example.payment_system.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/create")
    public Map<String, Object> createOrder(@RequestParam Integer userId,
                                           @RequestParam BigDecimal amount) {
        Map<String, Object> result = new HashMap<>();
        boolean success = orderService.createOrder(userId, amount);
        result.put("success", success);
        result.put("message", success ? "下单成功" : "下单失败");
        return result;
    }

    @GetMapping("/list")
    public Map<String, Object> listOrders(@RequestParam Integer userId) {
        Map<String, Object> result = new HashMap<>();
        List<Order> order = orderService.listOrders(userId);
        result.put("success", true);
        result.put("data", order);
        return result;
    }
}
