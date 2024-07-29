package com.springdatajpa.springboot.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "products",
schema = "ecommerce",
uniqueConstraints = {
        @UniqueConstraint(
                name = "sku_unique",
                columnNames = "stock_keeping_unit"
        )
})
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "stock_keeping_unit",nullable = false)
    private String sku;
    @Column(nullable = false)
    private String name;
    private String description;
    @Column(nullable = false)
    private BigDecimal price;
    @Column(nullable = false)
    private boolean active;
    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "date_create")
    @CreationTimestamp
    private LocalDateTime dateCreate;
    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDateTime lastUpdate;


}
