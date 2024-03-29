package com.darren.springbootmall.service.impl;

import com.darren.springbootmall.dao.ProductDao;
import com.darren.springbootmall.dto.ProductQueryParmas;
import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;
import com.darren.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParmas productQueryParmas) {
        return productDao.countProduct(productQueryParmas);
    }

    @Override
    public List<Product> getProducts(ProductQueryParmas productQueryParmas) {
        return productDao.getProducts(productQueryParmas);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    public Integer createProduct(ProductRequest productRequest) {
        return productDao.createProduct(productRequest);
    }

    @Override
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
