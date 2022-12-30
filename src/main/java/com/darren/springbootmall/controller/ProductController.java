package com.darren.springbootmall.controller;

import com.darren.springbootmall.constant.ProductCategory;
import com.darren.springbootmall.dto.ProductQueryParmas;
import com.darren.springbootmall.dto.ProductRequest;
import com.darren.springbootmall.model.Product;
import com.darren.springbootmall.service.ProductService;
import com.darren.springbootmall.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
            //查詢條件Filtering
            @RequestParam(required = false) ProductCategory category,
            @RequestParam(required = false) String search,
            //排序Sorting
            @RequestParam(defaultValue = "created_date") String orderBy,
            @RequestParam(defaultValue = "desc") String sort,
            //分業Pagination
            @RequestParam(defaultValue = "5") @Max(1000) @Min(0) Integer limit,
            @RequestParam(defaultValue = "0") @Min(0) Integer offset){

        ProductQueryParmas productQueryParmas = new ProductQueryParmas();
        productQueryParmas.setCategory(category);
        productQueryParmas.setSearch(search);
        productQueryParmas.setOrderBy(orderBy);
        productQueryParmas.setSort(sort);
        productQueryParmas.setLimit(limit);
        productQueryParmas.setOffset(offset);

        // 取得product list
        List<Product> productList = productService.getProducts(productQueryParmas);

        // 取得product總數
        Integer total = productService.countProduct(productQueryParmas);

        // 分頁
        Page<Product> page = new Page<>();
        page.setLimit(limit);
        page.setOffset(offset);
        page.setTotal(total);
        page.setResults(productList);
        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    @GetMapping("/products/{productId}")
   public ResponseEntity<Product> getProduct(@PathVariable Integer productId){

        Product product = productService.getProductById(productId);

        if(product != null){
            return ResponseEntity.status(HttpStatus.OK).body(product);
        }else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest){

        Integer productId = productService.createProduct(productRequest);

        Product product = productService.getProductById(productId);

        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct(@PathVariable Integer productId,
                                                 @RequestBody @Valid ProductRequest productRequest){

        //檢查product是否存在
        Product product = productService.getProductById(productId);

        if(product == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        //修改商品的數據
        productService.updateProduct(productId, productRequest);

        Product updatedProduct = productService.getProductById(productId);

        return  ResponseEntity.status(HttpStatus.OK).body(updatedProduct);
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deletaProduct(@PathVariable Integer productId){

        productService.deleteProductById(productId);

        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
