package com.chiangdarren.springbootmall.dao;

import com.chiangdarren.springbootmall.model.Product;

public interface ProductDao {


    Product getProductById(Integer productId);
}
