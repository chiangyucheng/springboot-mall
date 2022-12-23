package com.darren.springbootmall.service;

import com.darren.springbootmall.dao.ProductQueryParmas;
import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;

import java.util.List;

public interface ProductService {

    Integer countProduct(ProductQueryParmas productQueryParmas);

    List<Product> getProducts(ProductQueryParmas productQueryParmas);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
