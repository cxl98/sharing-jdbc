package com.cxl.sharing.entry;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

@Data
@ToString
public class Order {
    private Long orderId;

    private Long userId;

    private String orderCode;

    private String orderAmount;

    private String status;

    private Date createTime;
}
