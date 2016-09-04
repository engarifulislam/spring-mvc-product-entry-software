package com.arifulislam.dao;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.arifulislam.entites.Product;

public interface ProductRepositry extends JpaRepository<Product, Long>{

	public List<Product> findByDescription(String des);
	public Page<Product> findByDescription(String des, Pageable pageable);
	 
	@Query("select p from product p where p.description like :x")
	public Page<Product> chercherProducts(@Param("x") String mc,Pageable pageable);
	
	@Query("select p from product p where p.price >:x and p.price <:y")
	public List<Product> products(@Param("x")double price1,@Param("y")double price2);
	

}
