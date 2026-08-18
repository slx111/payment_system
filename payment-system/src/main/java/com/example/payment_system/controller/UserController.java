package com.example.payment_system.controller;

import com.example.payment_system.entity.User;
import com.example.payment_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public Map<String, Object> register(@RequestParam String username,
                                        @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        boolean success = userService.register(username, password);
        result.put("success", success);
        result.put("message", success ? "注册成功" : "用户名已存在或注册失败");
        return result;
    }

    @PostMapping("/login")
    public Map<String, Object> login(@RequestParam String username,
                                     @RequestParam String password) {
        Map<String, Object> result = new HashMap<>();
        User user = userService.login(username, password);
        if (user != null) {
            result.put("success", true);
            result.put("message", "登录成功");
            result.put("userId", user.getId());
            result.put("username", user.getUsername());
        } else {
            result.put("success", false);
            result.put("message", "用户名或密码错误");
        }
        return result;
    }
}
