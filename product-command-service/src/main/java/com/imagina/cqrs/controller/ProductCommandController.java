package com.imagina.cqrs.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.imagina.cqrs.dto.ProductEvent;
import com.imagina.cqrs.entity.Product;
import com.imagina.cqrs.service.ProductCommandService;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductCommandController {

    private ProductCommandService commandService;

    @PostMapping
    public Product createProduct(@RequestBody ProductEvent productEvent) {
        return commandService.createProduct(productEvent);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable long id, @RequestBody ProductEvent productEvent) {
        return commandService.updateProduct(id, productEvent);
    }
}
