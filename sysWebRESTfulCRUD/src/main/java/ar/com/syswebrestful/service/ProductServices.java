package ar.com.syswebrestful.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.syswebrestful.entity.Product;
import ar.com.syswebrestful.repository.ProductRepository;

@Service
public class ProductServices {

	@Autowired
	private ProductRepository productRepository;
	
	
	public List<Product> listAll(){
		return productRepository.findAll();
	}
	
	public void save(Product product) {
		productRepository.save(product);
	}
	
	public Product get(int id) {
		return productRepository.findById(id).get();
	}
	
	public void delete(int id) {
		productRepository.deleteById(id);
	}
	
}
