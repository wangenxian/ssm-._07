package com.itheima.ssm.service;

import com.com.itheima.ssm.domain.Orders;
import com.github.pagehelper.Page;
import com.sun.glass.ui.Size;

import java.util.List;

public interface IOrdersService {

    List<Orders> findAll(int page,int size) throws Exception;


//  Orders findById(String ordersId) throws Exception;

}
