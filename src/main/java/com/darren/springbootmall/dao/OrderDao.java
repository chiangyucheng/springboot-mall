package com.darren.springbootmall.dao;

import com.darren.springbootmall.dto.OrderQueryParams;
import com.darren.springbootmall.model.Order;
import com.darren.springbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemByOrderId(Integer orderId);

    Integer createOrder(Integer userId, Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItem);
}
