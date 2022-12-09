package com.darren.springbootmall.dao;

import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;

public interface ProductDao {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);
}
