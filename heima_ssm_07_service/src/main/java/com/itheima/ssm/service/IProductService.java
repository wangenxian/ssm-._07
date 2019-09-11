package com.itheima.ssm.service;

import com.itheima.ssm.Product;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-15 16:37
 **/
public interface IProductService {

    public List<Product> findAll() throws Exception;

    public  void  save(Product product) throws Exception;


    Product findProductById(String productNum);

    void updateByNum(String productNum,Product product);

}
