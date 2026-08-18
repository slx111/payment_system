package com.example.payment_system.mapper;

import com.example.payment_system.entity.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    // 插入新订单
    @Insert("INSERT INTO orders(user_id,amount) VALUES(#{userId},#{amount})")
    int insert(Order order);

    // 根据订单号查询订单
    @Select("SELECT * FROM orders WHERE user_id = #{userId}")
    List<Order> findByUserId(Integer userId);//多笔订单返回List集合
}
