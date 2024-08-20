package com.ducanh.demojpa.service;

import com.ducanh.demojpa.entity.OrderDetails;
import com.ducanh.demojpa.entity.Orders;
import com.ducanh.demojpa.entity.Users;
import com.ducanh.demojpa.repository.IOrderDetailsRepository;
import com.ducanh.demojpa.repository.IOrdersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrdersService implements IOrderService{

    @Autowired
    IOrdersRepository repository;

    @Autowired
    IOrderDetailsRepository ordersDetailsRepository;

    @Override
    public List<Orders> findAll() {
        return repository.findAll();
    }

    @Override
    public Orders findByUsers(Users user) {
        return repository.findByUser(user);
    }

    @Override
    public void createOrder(Orders order, OrderDetails orderDetails) {
        repository.save(order);
        ordersDetailsRepository.save(orderDetails);
    }
}
