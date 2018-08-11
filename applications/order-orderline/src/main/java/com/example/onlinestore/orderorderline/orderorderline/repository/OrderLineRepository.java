package com.example.onlinestore.orderorderline.orderorderline.repository;

import com.example.onlinestore.orderorderline.orderorderline.model.Order;
import com.example.onlinestore.orderorderline.orderorderline.model.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long>
{
    List<OrderLine> findByOrder(Order order);
}
