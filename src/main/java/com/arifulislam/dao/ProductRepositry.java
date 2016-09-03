package com.arifulislam.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.arifulislam.entites.Product;

public interface ProductRepositry extends JpaRepository<Product, Long>{

	

}
