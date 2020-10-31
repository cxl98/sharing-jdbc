package com.cxl.sharing.entry;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
@ApiModel(value = "Order",description = "订单信息")
public class Order {
    private Long orderId;

    private Long userId;

    private String orderCode;

    private String orderAmount;

    private String status;

    private Date createTime;
}
