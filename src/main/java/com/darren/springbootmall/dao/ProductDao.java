package com.darren.springbootmall.dao;

import com.darren.springbootmall.constant.ProductCategory;
import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    Integer countProduct(ProductQueryParmas productQueryParmas);

    List<Product> getProducts(ProductQueryParmas productQueryParmas);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);


}
