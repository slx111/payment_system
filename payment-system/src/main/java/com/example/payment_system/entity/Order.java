package com.example.payment_system.entity;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order {
    private Integer id;
    private Integer userId;//下单用户ID
    private BigDecimal amount;//金额
    private String status;//订单状态
    private LocalDateTime createdAt;//创建时间
}
