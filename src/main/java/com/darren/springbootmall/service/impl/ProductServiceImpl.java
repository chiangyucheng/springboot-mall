package com.darren.springbootmall.service.impl;

import com.darren.springbootmall.dao.ProductDao;
import com.darren.springbootmall.model.Product;
import com.darren.springbootmall.service.ProductService;
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
