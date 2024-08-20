package com.ducanh.demojpa.repository;

import com.ducanh.demojpa.entity.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IOrderDetailsRepository extends JpaRepository<OrderDetails, Long> {
}