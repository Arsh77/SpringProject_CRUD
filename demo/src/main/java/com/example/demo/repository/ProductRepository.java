package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{
	//derived method
	Product findByName(String name);
	//derived method
	String deleteByName(String name);


}
