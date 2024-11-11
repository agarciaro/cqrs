package com.imagina.cqrs.service;

import com.imagina.cqrs.dto.ProductEvent;
import com.imagina.cqrs.entity.Product;

public interface ProductCommandService {

    Product createProduct(ProductEvent productEvent);

    Product updateProduct(long id,ProductEvent productEvent);

}
