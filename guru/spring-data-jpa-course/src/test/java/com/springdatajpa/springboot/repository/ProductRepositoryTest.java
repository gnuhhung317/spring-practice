package com.springdatajpa.springboot.repository;

import com.springdatajpa.springboot.entity.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
//@DataJpaTest
class ProductRepositoryTest {
    @Autowired
    private ProductRepository productRepository;

    @Test
    void saveMethod() throws InterruptedException {
        Product product = new Product();
        product.setSku("123");
        product.setName("iPhone");
        product.setPrice(new BigDecimal(1000));
        product.setActive(true);
        product.setImageUrl("test.img");
        product.setDescription("test description");
        Product savedProduct = productRepository.save(product);
        System.out.println(savedProduct);

        Thread.sleep(5000);
        savedProduct.setSku("100");

        Product updatedProduct = productRepository.save(savedProduct);
        System.out.println(updatedProduct);
    }

    @Test
    void findAllMethod() {
        productRepository.findAll().forEach(product -> System.out.println(product));
    }
}