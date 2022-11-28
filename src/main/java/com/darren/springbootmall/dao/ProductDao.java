package com.darren.springbootmall.dao;

import com.darren.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);
}
