package com.ducanh.demojpa.service;

import com.ducanh.demojpa.entity.OrderDetails;
import com.ducanh.demojpa.entity.Orders;
import com.ducanh.demojpa.entity.Users;

import java.util.List;

public interface IOrderService {
    public List<Orders> findAll();

    public Orders findByUsers(Users user);

    public void createOrder(Orders order, OrderDetails orderDetails);
}
