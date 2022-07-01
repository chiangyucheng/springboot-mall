package com.chiangdarren.springbootmall.service.impl;

import com.chiangdarren.springbootmall.dao.ProductDao;
import com.chiangdarren.springbootmall.model.Product;
import com.chiangdarren.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
       return productDao.getProductById(productId);
    }
}
