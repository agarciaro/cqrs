package com.imagina.cqrs.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imagina.cqrs.entity.Product;
import com.imagina.cqrs.service.ProductQueryService;

import lombok.AllArgsConstructor;

@RequestMapping("/products")
@AllArgsConstructor
@RestController
public class ProductQueryController {

	private ProductQueryService queryService;

	@GetMapping
	public List<Product> fetchAllProducts() {
		Iterable<Product> products = queryService.getProducts();
		return StreamSupport.stream(products.spliterator(), false).collect(Collectors.toList());
	}
}