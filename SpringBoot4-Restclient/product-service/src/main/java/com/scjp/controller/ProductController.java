package com.scjp.controller;

import com.scjp.entity.Product;
import com.scjp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public List<Product> addProducts(@RequestBody List<Product> products) {
        if(products == null || products.isEmpty()) {
            throw new IllegalArgumentException("Product list cannot be null or empty");
        }
        return productService.saveProducts(products);
    }

    @GetMapping
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/{category}")
    public List<Product> getProduct(@PathVariable String category) {
        return productService.getProduct(category);
    }


}