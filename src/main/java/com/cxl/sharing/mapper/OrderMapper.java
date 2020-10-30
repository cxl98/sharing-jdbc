package com.cxl.sharing.mapper;

import com.cxl.sharing.entry.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderMapper {
    @Insert("insert into t_order(orderId,userId,orderCode,orderAmount,status,createTime) values(#{orderId},#{userId},#{orderCode},#{orderAmount},#{status},#{createTime})")
    int insert(Order order);

    int deleteByPrimaryKey(String orderId);

    int insertSelective(Order record);
    @Select("Select * from t_order  where order_id = #{orderId} ")
    Order selectByPrimaryKey(String orderId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}
