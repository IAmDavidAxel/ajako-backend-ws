package com.example.ajakobackendserver.api.resource.product;

import com.example.ajakobackendserver.application.service.product.ProductService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class ProductJsonResourceTest {

	private ProductJsonResource productJsonResource;

	private ProductService productService;
	private ProductDto productDto;

	@Before
	public void setUp(){
		productJsonResource= new ProductJsonResource(productService);
	}

	@Test
	public void whenCreatingANewProduct_thenDelegateToService()throws Exception{
		productJsonResource.create(productDto);

		verify(productService).create(productDto);
	}
}
