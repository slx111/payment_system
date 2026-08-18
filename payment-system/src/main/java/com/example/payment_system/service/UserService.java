package com.example.payment_system.service;

import com.example.payment_system.entity.User;
import com.example.payment_system.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    // 注册（密码加密）
    public boolean register(String username, String password) {
        // 检查用户名是否已存在
        if (userMapper.findByUsername(username) != null) {
            return false;
        }
        User user = new User();
        user.setUsername(username);
        // 密码 BCrypt 加密
        String encodedPwd = encoder.encode(password);
        user.setPassword(encodedPwd);
        return userMapper.insert(user) > 0;
    }

    // 登录验证（验证密码）
    public User login(String username, String password) {
        User user = userMapper.findByUsername(username);
        if (user != null && encoder.matches(password, user.getPassword())) {
            return user;  // 登录成功
        }
        return null;
    }
}
