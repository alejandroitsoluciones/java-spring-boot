package ar.com.syswebrestful.controller;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ar.com.syswebrestful.entity.Product;
import ar.com.syswebrestful.service.ProductServices;

@RestController
public class ProductController {
	
	@Autowired
	private ProductServices productServices;
	
	@GetMapping("/products")
	public List<Product> list(){
		return productServices.listAll();
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<Product> get(@PathVariable int id) {
		try {
			Product product = productServices.get(id);
			return new ResponseEntity<Product>(product, HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PostMapping("/products")
	public void add(@RequestBody Product product) {
		productServices.save(product);
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<?> update(@RequestBody Product product, @PathVariable int id) {
		try {
			Product existProduct = productServices.get(id);
			productServices.save(product);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<?> delete(@PathVariable int id){
		try {
			Product existProduct = productServices.get(id);
			productServices.delete(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
}
