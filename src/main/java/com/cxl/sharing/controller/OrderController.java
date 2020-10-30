package com.cxl.sharing.controller;

import com.alibaba.fastjson.JSONObject;
import com.cxl.sharing.entry.Order;
import com.cxl.sharing.service.OrderService;
import com.cxl.sharing.util.Id;
import com.cxl.sharing.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
@Api(tags ="订单管理")
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private Id id;

    @ApiOperation(value = "添加用户", notes = "添加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "orderCode", value = "订单的代码" , required = true, dataType = "String"),
            @ApiImplicitParam(name = "orderAmount", value = "购买数量", required = true, dataType = "String")
    })
    @PostMapping("/add")
    public Result add(@RequestBody String orderParam){
        Order order = JSONObject.parseObject(orderParam, Order.class);
        order.setUserId(id.getNextId());
        order.setUserId(id.getNextId());
        order.setStatus("1");
        order.setCreateTime(new Date());
        orderService.add(order);
        return Result.ok();
    }
    @ApiOperation(value = "获取某个订单详细信息", notes = "通过orderId查询订单")
    @ApiImplicitParam(name = "orderId", value = "订单的唯一标识", required = true, dataType = "String")
    @RequestMapping("/findById")
    public Order findById(String orderId){
        return orderService.findById(orderId);
    }
}
