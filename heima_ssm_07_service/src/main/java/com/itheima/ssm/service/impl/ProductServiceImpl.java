package com.itheima.ssm.service.impl;


import com.itheima.ssm.Product;
import com.itheima.ssm.UserInfo;
import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program: heima_ssm_07
 * @description:
 * @author: wangenxian
 * @create: 2019-07-15 16:38
 **/
@Service("productService")
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductDao productDao;
    @Override
    public List<Product> findAll() throws Exception {
        System.out.println("数据取出来了");
        return productDao.findAll();
    }
    @Override
    public void save(Product product) throws Exception {
         System.out.println("save方法执行来");
         productDao.save(product);
    }

    @Override
    public Product findProductById(String productNum) {
        System.out.println("findProductById方法执行了");
        Product product =productDao.findProductById(productNum);
        System.out.println(product);
        return product;
    }

    @Override
    public void updateByNum(String productNum, Product product) {

            productDao.updateByNum(productNum,product);

    }
}
