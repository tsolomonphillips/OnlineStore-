package com.example.onlinestore.orderorderline.orderorderline.service;

import com.example.onlinestore.orderorderline.orderorderline.model.Order;
import com.example.onlinestore.orderorderline.orderorderline.model.OrderLine;
import com.example.onlinestore.orderorderline.orderorderline.repository.OrderLineRepository;
import com.example.onlinestore.orderorderline.orderorderline.repository.OrderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderLineService
{
    private OrderLineRepository orderLineRepository;
    private OrderRepository orderRepository;

    public OrderLineService(OrderLineRepository orderLineRepository,
                            OrderRepository orderRepository)
    {
        this.orderLineRepository = orderLineRepository;
        this.orderRepository = orderRepository;
    }

    public ResponseEntity createOrderLine(Long orderId, OrderLine orderLine)
    {
        Order order = orderRepository.getOne(orderId);

        orderLine.setPrice(orderLine.getPrice());
        orderLine.setProductId(orderLine.getProductId());
        orderLine.setQuantity(orderLine.getQuantity());
        orderLine.setShipmentId(orderLine.getShipmentId());

        orderLine.setOrder(order);
        orderLineRepository.save(orderLine);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    public List<OrderLine> getOrderLine(Long orderId)
    {
        Order order = orderRepository.getOne(orderId);
        return orderLineRepository.findByOrder(order);
    }

    public ResponseEntity updateOrderLine(Long orderId, Long orderLineId, OrderLine orderLine)
    {
        OrderLine orderToUpdate = orderLineRepository.getOne(orderLineId);
        orderToUpdate.setShipmentId(orderLine.getShipmentId());
        orderToUpdate.setQuantity(orderLine.getQuantity());
        orderToUpdate.setPrice(orderLine.getPrice());
        orderToUpdate.setProductId(orderLine.getProductId());

        orderToUpdate.setOrder(orderRepository.getOne(orderId));
        orderLineRepository.save(orderToUpdate);
        return new ResponseEntity(HttpStatus.ACCEPTED);
    }

    public ResponseEntity deleteOrderLine(Long orderId, Long orderLineId)
    {
        OrderLine orderLine = orderLineRepository.getOne(orderLineId);
        orderLine.setOrder(orderRepository.getOne(orderId));
        orderLineRepository.delete(orderLine);

        return new ResponseEntity(HttpStatus.ACCEPTED);
    }
}
