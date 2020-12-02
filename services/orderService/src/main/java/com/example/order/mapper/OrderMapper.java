package com.example.order.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.order.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper extends BaseMapper<Order> {

    void create(Order order);
    void updateStatus(@Param("orderId") Long orderId, @Param("status") Integer status);
}
