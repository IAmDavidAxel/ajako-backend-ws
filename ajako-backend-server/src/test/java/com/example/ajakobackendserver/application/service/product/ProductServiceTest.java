package com.example.ajakobackendserver.application.service.product;

import com.example.ajakobackendserver.api.resource.product.ProductDto;
import com.example.ajakobackendserver.domain.product.Product;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

	private ProductService productService;

	@Mock
	private ProductRepository productRepository;
	@Mock
	private ProductFactory productFactory;

	private Product product;
	private ProductDto productDto;

	@Before
	public void setUp(){
		productService = new ProductService(productFactory,productRepository);
	}

}
