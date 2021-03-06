package com.itheima.ssm.service.impl;

import com.github.pagehelper.PageHelper;
import com.itheima.ssm.Orders;
import com.itheima.ssm.dao.IOrdersDao;
import com.itheima.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("ordersService")
@Transactional
public class OrdersServiceImpl implements IOrdersService {

    @Autowired
    private IOrdersDao ordersDao;

    @Override
    public List<Orders> findAll(int page, int size ) throws Exception {
        //代表在查询时，会帮助我们分页。
        System.out.println("service dao分页方法执行了");
        PageHelper.startPage(page, size);
        return ordersDao.findAll();
    }


}
