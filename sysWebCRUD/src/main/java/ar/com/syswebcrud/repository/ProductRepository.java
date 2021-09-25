package ar.com.syswebcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ar.com.syswebcrud.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
