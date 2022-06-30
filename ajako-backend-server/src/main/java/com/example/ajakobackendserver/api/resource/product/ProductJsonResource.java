package com.example.ajakobackendserver.api.resource.product;

import com.example.ajakobackendserver.application.service.product.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("/product")
public class ProductJsonResource {

	private ProductService productService;

	public ProductJsonResource(ProductService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<Object> create(@RequestBody ProductDto productDto) {

		productService.create(productDto);

		return new ResponseEntity<>("product created successfully", HttpStatus.CREATED);
	}
}
