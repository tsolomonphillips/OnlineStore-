package com.example.onlinestore.orderorderline.orderorderline.repository;

import com.example.onlinestore.orderorderline.orderorderline.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>
{
    List<Order> findAllByAccountIdOrderByOrderDateDesc(Long orderId);
}
