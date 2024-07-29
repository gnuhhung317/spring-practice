package com.duchung.search.service;


import com.duchung.search.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    List<Product> searchProducts(String query);
    Product createProduct(Product product);
}
