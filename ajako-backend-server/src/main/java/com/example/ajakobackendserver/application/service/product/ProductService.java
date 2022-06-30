package com.example.ajakobackendserver.application.service.product;

import com.example.ajakobackendserver.api.resource.product.ProductDto;
import com.example.ajakobackendserver.domain.product.ProductFactory;
import com.example.ajakobackendserver.domain.product.ProductRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	private ProductFactory productFactory;
	private  ProductRepository productRepository;

	public ProductService(ProductFactory productFactory, ProductRepository productRepository) {

		this.productFactory = productFactory;
		this.productRepository = productRepository;
	}

	public void create(ProductDto productDto) {



	}
}
