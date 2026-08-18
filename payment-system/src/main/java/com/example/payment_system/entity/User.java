// User.java
package com.example.payment_system.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class User {
    private Integer id;
    private String username;
    private String password; // 存储加密后的密码
    private BigDecimal balance;
    private LocalDateTime createdAt;
}

