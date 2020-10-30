package com.cxl.sharing.service;

import com.cxl.sharing.entry.Order;
import com.cxl.sharing.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public int add(Order order){
        return orderMapper.insert(order);
    }

    public Order findById(String orderId) {
        return orderMapper.selectByPrimaryKey(orderId);
    }
}
