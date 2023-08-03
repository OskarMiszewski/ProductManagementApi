package com.productmanager.productmanager.repository;

import com.productmanager.productmanager.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    Optional<Product> deleteProductById(Long id);

    void deleteProductById(Long id);

    Optional<Product> findProductById(Long id);


}
