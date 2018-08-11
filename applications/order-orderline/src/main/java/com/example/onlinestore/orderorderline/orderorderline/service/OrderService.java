package com.example.onlinestore.orderorderline.orderorderline.service;

import com.example.onlinestore.orderorderline.orderorderline.model.Order;
import com.example.onlinestore.orderorderline.orderorderline.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService
{
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository)
    {
        this.orderRepository = orderRepository;
    }

    public ResponseEntity createOrder(Order order)
    {
        order.setOrderDate(order.getOrderDate());
        order.setOrderNumber(order.getOrderNumber());
        order.setAccountId(order.getAccountId());
        order.setShippingAddressId(order.getShippingAddressId());

        orderRepository.save(order);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<Order> getOrder(Long accountId)
    {
        return orderRepository.findAllByAccountIdOrderByOrderDateDesc(accountId);
    }

    public ResponseEntity updateOrder(Long orderId, Order order)
    {
        Order orderToUpdate = orderRepository.getOne(orderId);
        orderToUpdate.setShippingAddressId(order.getShippingAddressId());
        orderToUpdate.setAccountId(order.getAccountId());

        orderRepository.save(orderToUpdate);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public ResponseEntity deleteOrder(Long orderId)
    {
        Order order = orderRepository.getOne(orderId);
        orderRepository.delete(order);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
