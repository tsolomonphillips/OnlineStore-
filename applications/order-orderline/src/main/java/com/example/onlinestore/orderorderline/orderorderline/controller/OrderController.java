package com.example.onlinestore.orderorderline.orderorderline.controller;

import com.example.onlinestore.orderorderline.orderorderline.model.Order;
import com.example.onlinestore.orderorderline.orderorderline.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController
{
    private OrderService orderService;

    public OrderController(OrderService orderService)
    {
        this.orderService = orderService;
    }

    @PostMapping("")
    public ResponseEntity addOrder(@RequestBody Order order)
    {
        orderService.createOrder(order);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping("/{accountId}")
    public List<Order> getOrdersByAccount(@PathVariable (name = "account_id") Long accountId)
    {
        return orderService.getOrder(accountId);
    }
}
