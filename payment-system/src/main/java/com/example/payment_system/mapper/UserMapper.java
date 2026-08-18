package com.example.payment_system.mapper;

import com.example.payment_system.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    // 注册新用户，使用 #{} 预编译，防止SQL注入 将java的user对象翻译成INSERT语句存进数据库
    @Insert("INSERT INTO user(username, password) VALUES(#{username}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(User user);

    // 根据用户名查询用户，使用 #{} 预编译，将mysql翻译成java
    @Select("SELECT * FROM user WHERE username = #{username}")
    User findByUsername(String username);
}
