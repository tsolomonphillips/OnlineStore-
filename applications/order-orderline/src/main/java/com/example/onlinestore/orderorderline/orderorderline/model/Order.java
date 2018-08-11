package com.example.onlinestore.orderorderline.orderorderline.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id")
    private Long orderId;

    private Long accountId;
    private String orderNumber;
    private LocalDate orderDate;
    private Long shippingAddressId;

    @OneToMany(mappedBy = "order", orphanRemoval = true, cascade = CascadeType.ALL)
    private List<OrderLine> orderLineItems;
    private Double totalPrice;

    public Order()
    {

    }

    public Order(Long orderId, Long accountId, String orderNumber, LocalDate orderDate,
                 Long shippingAddressId, List<OrderLine> orderLineItems, Double totalPrice)
    {
        this.orderId = orderId;
        this.accountId = accountId;
        this.orderNumber = orderNumber;
        this.orderDate = orderDate;
        this.shippingAddressId = shippingAddressId;
        this.orderLineItems = orderLineItems;
        this.totalPrice = totalPrice;
    }

    public Long getOrderId()
    {
        return orderId;
    }

    public Long getAccountId()
    {
        return accountId;
    }

    public void setAccountId(Long accountId)
    {
        this.accountId = accountId;
    }

    public String getOrderNumber()
    {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber)
    {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderDate()
    {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate)
    {
        this.orderDate = orderDate;
    }

    public Long getShippingAddressId()
    {
        return shippingAddressId;
    }

    public void setShippingAddressId(Long shippingAddressId)
    {
        this.shippingAddressId = shippingAddressId;
    }

    public List<OrderLine> getOrderLineItems()
    {
        return orderLineItems;
    }

    public void setOrderLineItems(List<OrderLine> orderLineItems)
    {
        this.orderLineItems = orderLineItems;
    }

    public Double getTotalPrice()
    {
        for (OrderLine orderLineItem : this.orderLineItems)
        {
            this.totalPrice += orderLineItem.getPrice();
            setTotalPrice(totalPrice);
        }

        return totalPrice;
    }

    private void setTotalPrice(Double totalPrice)
    {
        this.totalPrice = totalPrice;
    }
}
