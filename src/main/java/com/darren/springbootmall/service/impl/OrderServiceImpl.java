package com.darren.springbootmall.service.impl;

import com.darren.springbootmall.dao.OrderDao;
import com.darren.springbootmall.dao.ProductDao;
import com.darren.springbootmall.dto.BuyItem;
import com.darren.springbootmall.dto.CreateOrderRequest;
import com.darren.springbootmall.model.Order;
import com.darren.springbootmall.model.OrderItem;
import com.darren.springbootmall.model.Product;
import com.darren.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Transactional//執行過程中若發生exception的話，會去復原已經執行過的資料庫操作
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {

        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for(BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product =productDao.getProductById(buyItem.getProductId());

            //計算總價
            int amount = buyItem.getQuantity() * product.getPrice();
            totalAmount += amount;

            //轉換ButItem To OrderItem
            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);

        }

        //創建訂單
        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);
        return orderId;
    }
}
