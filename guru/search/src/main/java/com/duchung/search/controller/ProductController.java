package com.duchung.search.controller;

import com.duchung.search.entity.Product;
import com.duchung.search.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    private ProductService service;

    @GetMapping("/search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam("query") String query){
        return ResponseEntity.ok(service.searchProducts(query));
    }
    @PostMapping("/add")
    public Product createProduct(@RequestBody Product product){
        return service.createProduct(product);
    }
}
