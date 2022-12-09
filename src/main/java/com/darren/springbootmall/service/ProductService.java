package com.darren.springbootmall.service;

import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;

public interface ProductService {

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
