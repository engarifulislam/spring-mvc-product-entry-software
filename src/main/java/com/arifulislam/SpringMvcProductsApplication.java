package com.arifulislam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.arifulislam.dao.ProductRepositry;
import com.arifulislam.entites.Product;

@SpringBootApplication
public class SpringMvcProductsApplication {

	public static void main(String[] args) {
		ApplicationContext e = SpringApplication.run(SpringMvcProductsApplication.class, args);
		ProductRepositry dao = e.getBean(ProductRepositry.class);
		dao.save(new Product("Nokia", 2000));
		dao.save(new Product("Lumia", 2300));
		dao.save(new Product("Arif", 4000));
		dao.save(new Product("Nok", 9000));
		dao.save(new Product("jdud", 2000));
		
		
	}
}
