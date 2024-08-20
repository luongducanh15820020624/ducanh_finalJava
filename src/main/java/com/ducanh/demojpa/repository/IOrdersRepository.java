package com.ducanh.demojpa.repository;

import com.ducanh.demojpa.entity.Orders;
import com.ducanh.demojpa.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrdersRepository extends JpaRepository<Orders, Long> {
    public Orders findByUser(Users users);
}