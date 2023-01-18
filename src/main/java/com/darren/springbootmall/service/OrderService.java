package com.darren.springbootmall.service;

import com.darren.springbootmall.dto.CreateOrderRequest;
import com.darren.springbootmall.dto.OrderQueryParams;
import com.darren.springbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
