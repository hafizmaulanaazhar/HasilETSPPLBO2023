package com.etsCaffe.orderServices.repository;

import com.etsCaffe.orderServices.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}