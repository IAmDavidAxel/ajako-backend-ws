package com.example.ajakobackendserver.domain.product;

import javax.persistence.*;

@Entity
@Table(name = "products")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	 public Product(){

	 }


}
