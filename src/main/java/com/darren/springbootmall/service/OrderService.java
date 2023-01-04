package com.darren.springbootmall.service;

import com.darren.springbootmall.dto.CreateOrderRequest;
import com.darren.springbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);

    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
