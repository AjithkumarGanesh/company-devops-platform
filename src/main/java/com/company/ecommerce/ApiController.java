package com.company.ecommerce;

import java.time.Instant;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ApiController {

    @GetMapping("/")
    public Map<String, Object> home() {
        return Map.of(
                "application", "ecommerce-api",
                "message", "E-commerce API is running",
                "version", "1.0.0",
                "timestamp", Instant.now().toString()
        );
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        return Map.of(
                "status", "UP",
                "application", "ecommerce-api"
        );
    }

    @GetMapping("/api/products")
    public List<Product> products() {
        return List.of(
                new Product(101, "Wireless Mouse", 799.00, "available"),
                new Product(102, "USB-C Keyboard", 1499.00, "available"),
                new Product(103, "Laptop Stand", 999.00, "limited")
        );
    }

    public record Product(int id, String name, double priceInr, String availability) {}
}
