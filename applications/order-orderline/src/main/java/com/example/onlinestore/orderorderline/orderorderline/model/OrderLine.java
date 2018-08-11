package com.example.onlinestore.orderorderline.orderorderline.model;

import javax.persistence.*;

@Entity
@Table(name = "orderLine")
public class OrderLine
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "orderLine_id")
    private Long orderLineId;

    private Long productId;
    private Integer quantity;
    private Double price;
    private Double totalPrice;
    private Long shipmentId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;

    public OrderLine()
    {

    }

    public OrderLine(Long orderLineId, Long productId, Integer quantity,
                     Double price, Double totalPrice, Long shipmentId, Order order)
    {
        this.orderLineId = orderLineId;
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
        this.totalPrice = totalPrice;
        this.shipmentId = shipmentId;
        this.order = order;
    }

    public Long getOrderLineId()
    {
        return orderLineId;
    }

    public void setOrderLineId(Long orderLineId)
    {
        this.orderLineId = orderLineId;
    }

    public Long getProductId()
    {
        return productId;
    }

    public void setProductId(Long productId)
    {
        this.productId = productId;
    }

    public Integer getQuantity()
    {
        return quantity;
    }

    public void setQuantity(Integer quantity)
    {
        this.quantity = quantity;
    }

    public Double getPrice()
    {
        return price;
    }

    public void setPrice(Double price)
    {
        this.price = price;
    }

    public Double getTotalPrice()
    {
        setTotalPrice(this.price * this.quantity);
        return totalPrice;
    }

    private void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public Long getShipmentId()
    {
        return shipmentId;
    }

    public void setShipmentId(Long shipmentId)
    {
        this.shipmentId = shipmentId;
    }

    public Order getOrder()
    {
        return order;
    }

    public void setOrder(Order order)
    {
        this.order = order;
    }
}
