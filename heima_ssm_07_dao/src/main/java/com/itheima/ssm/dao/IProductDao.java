package com.itheima.ssm.dao;

import com.itheima.ssm.Product;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-15 16:35
 **/
public interface IProductDao {

    @Select("select * from product")
//    @Results({
//            @Result(column="productNum", property="studId"),
//            @Result(column="name", property="name"),
//            @Result(column="email", property="email"),
//            @Result(column="addr_id", property="address.addrId"
//    })
//
    @Results({
            @Result(property = "productNum", column = "productNum"),
            @Result(property = "productName", column = "productName"),
            @Result(property = "cityName", column = "cityName"),
            @Result(property = "productPrice", column = "productPrice"),
            @Result(property = "productDesc", column = "productDesc"),
            @Result(property = "productStatus", column = "productStatus"),


    })
    public List<Product> findAll() throws Exception;


    @Insert("insert into product(productNum,productName,cityName,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{productPrice},#{productDesc},#{productStatus})")

            public void save(Product product);

}
