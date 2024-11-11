package com.imagina.cqrs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imagina.cqrs.entity.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
}
