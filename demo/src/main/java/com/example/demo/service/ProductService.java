package com.example.demo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Product;
import com.example.demo.repository.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository repository;

	public Product saveProduct(Product product) {
		return repository.save(product);
	}

	public List<Product> saveProducts(List<Product> product) {
		return repository.saveAll(product);
	}

	public List<Product> getProducts() {
		return repository.findAll();
	}

	public Product getProductById(int id) {
		return repository.findById(id).orElse(null);
	}
	//derived method
	public Product getProductByName(String name) {
		return repository.findByName(name);
	}

	public String deleteProductById(int id) {
		repository.deleteById(id);
		return "deleted product with id : " + id;
	}
	
	//derived method
	@Transactional
	@Modifying
	public String deleteProductsByName(String name) {
		repository.deleteByName(name);
		return "deleted product with name : " + name;
	}
	
	public Product updateProduct(Product p) {
		return repository.save(p);
	}
	
}
