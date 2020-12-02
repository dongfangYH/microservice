package com.example.order.service.impl;

import com.example.order.entity.Order;
import com.example.order.feign.AccountClient;
import com.example.order.feign.IdGenerator;
import com.example.order.feign.StorageClient;
import com.example.order.service.OrderService;
import com.example.order.tcc.OrderTccAction;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author yuanhang.liu@tcl.com
 * @description
 * @date 2020-12-01 16:17
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private AccountClient accountClient;
    @Resource
    private StorageClient storageClient;

    @Resource
    private OrderTccAction orderTccAction;

    @GlobalTransactional
    @Override
    public void create(Order order) {
        // 从全局唯一id发号器获得id
        Long orderId = IdGenerator.getId();
        order.setId(orderId);

        // orderMapper.create(order);

        // 这里修改成调用 TCC 第一节端方法
        orderTccAction.prepareCreateOrder(
                null,
                order.getId(),
                order.getUserId(),
                order.getProductId(),
                order.getCount(),
                order.getMoney());


        // 修改库存
        storageClient.decrease(order.getProductId(), order.getCount());

        // 修改账户余额
        accountClient.decrease(order.getUserId(), order.getMoney());

    }
}
