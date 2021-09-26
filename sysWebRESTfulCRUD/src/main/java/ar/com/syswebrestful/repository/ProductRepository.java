package ar.com.syswebrestful.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.syswebrestful.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
