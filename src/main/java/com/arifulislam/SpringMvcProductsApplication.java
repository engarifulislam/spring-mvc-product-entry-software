package com.arifulislam;


import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

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
		dao.save(new Product("Rkas", 430));
		
		
		// Show Product list 
		System.err.println("-----------------------------");
		System.out.println("List item");
		List<Product> prods=dao.findAll();
		for(Product p:prods){
			System.out.println(p.getDescription()+"---"+ p.getPrice());
		}
		
		// Show Pagination and find all product also select only 4 product
		
		Page<Product> pageProducts=dao.findAll(new PageRequest(0, 4));
		System.out.println("Page Counter: " +pageProducts.getNumber());
		System.out.println("Total Page: "+pageProducts.getTotalPages() );
		System.out.println("Number of Product :" +pageProducts.getTotalElements());
		
		List<Product> produc2=pageProducts.getContent();
		for(Product p:produc2){
			System.out.println(p.getDescription()+"" +p.getPrice());
		}
		
	//Product p=dao.findOne(L1)
		
	System.err.println("-----------------------------");
	System.out.println("Product find One(L1)");
		Page<Product> produc3=dao.chercherProducts("%L%", new PageRequest(0, 2));
		
		for(Product p:produc3.getContent()){
			System.out.println(p.getDescription()+"" +p.getPrice());
		}
		
		
		
		
		
		
	}
}
