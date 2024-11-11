package com.imagina.cqrs.service;

import com.imagina.cqrs.dto.ProductEvent;
import com.imagina.cqrs.entity.Product;

public interface ProductQueryService {

    Iterable<Product> getProducts();

    void processProductEvents(ProductEvent productEvent);

}
