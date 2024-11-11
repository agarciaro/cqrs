package com.imagina.cqrs.service.impl;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.imagina.cqrs.dto.ProductEvent;
import com.imagina.cqrs.entity.Product;
import com.imagina.cqrs.repository.ProductRepository;
import com.imagina.cqrs.service.ProductQueryService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductQueryServiceImpl implements ProductQueryService {

    private ProductRepository repository;

    public Iterable<Product> getProducts() {
        return repository.findAll();
    }

    @KafkaListener(topics = "product-event-topic", groupId = "product-event-group")
    public void processProductEvents(ProductEvent productEvent) {
        Product product = productEvent.getProduct();
        if (productEvent.getEventType().equals("CreateProduct")) {
            repository.save(product);
        }
        if (productEvent.getEventType().equals("UpdateProduct")) {
            Product existingProduct = repository.findById(product.getId()).orElse(null);
            if (existingProduct != null) {
                existingProduct.setName(product.getName());
                existingProduct.setPrice(product.getPrice());
                existingProduct.setDescription(product.getDescription());
                repository.save(existingProduct);
            }
        }
    }
}