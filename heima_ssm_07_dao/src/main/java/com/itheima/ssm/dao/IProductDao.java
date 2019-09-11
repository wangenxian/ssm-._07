package com.itheima.ssm.dao;

import com.itheima.ssm.Product;
import org.apache.ibatis.annotations.*;

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
            @Result(property = "productNum", column = "product_num"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDesc", column = "product_desc"),
            @Result(property = "productStatus", column = "product_status"),


    })
    public List<Product> findAll() throws Exception;


    @Insert("insert into product(productNum,productName,cityName,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{productPrice},#{productDesc},#{productStatus})")

            public void save(Product product);

    @Select("select * from product where product_num = #{productNum}")

    @Results({
            @Result(property = "productNum", column = "product_num"),
            @Result(property = "productName", column = "product_name"),
            @Result(property = "cityName", column = "city_name"),
            @Result(property = "productPrice", column = "product_price"),
            @Result(property = "productDesc", column = "product_desc"),
            @Result(property = "productStatus", column = "product_status"),

    })
            Product findProductById(@Param( value = "productNum") String productNum);

    @Update("UPDATE  product set  product_name = #{product.productName} ,product_price = #{product.productPrice} WHERE product_num = #{productNum}")
//    @Results({
//            @Result(property = "productNum", column = "product_num"),
//            @Result(property = "productName", column = "product_name"),
//            @Result(property = "productPrice", column = "product_price"),
//    })
    void updateByNum(@Param( value = "productNum") String productNum, @Param(value = "product") Product product);
}
