package com.imagina.cqrs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.imagina.cqrs.entity.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
}