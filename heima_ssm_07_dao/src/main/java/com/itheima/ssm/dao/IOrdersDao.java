package com.itheima.ssm.dao;

import com.itheima.ssm.Orders;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IOrdersDao {

    @Select("select * from orders")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "orderNum", column = "order_num"),
            @Result(property = "orderTime", column = "order_time"),
            @Result(property = "orderDesc", column = "order_desc"),
            @Result(property = "orderName", column = "order_name"),
            @Result(property = "money", column = "money"),
    })
     List<Orders> findAll() throws Exception;

//
//    //多表操作
//    @Select("select * from orders where id=#{ordersId}")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "orderNum", column = "orderNum"),
//            @Result(property = "orderTime", column = "orderTime"),
//            @Result(property = "orderStatus", column = "orderStatus"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "peopleCount", column = "peopleCount"),
//            @Result(property = "payType", column = "payType"),
//            @Result(property = "orderDesc", column = "orderDesc"),
//            @Result(property = "product", column = "productId", javaType = Product.class, one = @One(select = "com.itheima.ssm.dao.IProductDao.findById")),
//            @Result(property = "member",column = "memberId",javaType = Member.class,one = @One(select = "com.itheima.ssm.dao.IMemberDao.findById")),
//            @Result(property = "travellers",column = "id",javaType = List.class,many = @Many(select = "com.itheima.ssm.dao.ITravellerDao.findByOrdersId"))
//    })
//    public Orders findById(String ordersId) throws Exception;
}
