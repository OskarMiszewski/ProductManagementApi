package com.productmanager.productmanager.service;

import com.productmanager.productmanager.exceptions.UserNotFoundException;
import com.productmanager.productmanager.model.Product;
import com.productmanager.productmanager.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService
{
    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public int test()
    {
        return 404;
    }

    public Product addProduct(Product product)
    {
//        product.setProductCode(UUID.randomUUID().toString());
        return productRepository.save(product);
    }

    public List<Product> findAllProducts()
    {
        return productRepository.findAll();
    }

    public Product updateProduct(Product product)
    {
        return productRepository.save(product);
    }

    public Product findProductById(Long id)
    {
        return productRepository.findProductById(id).orElseThrow(() -> new UserNotFoundException("Product by id" + id + "was not found"));
    }

//    public Optional<Product> deleteProduct(Long id) { return productRepository.deleteProductById(id);}

    public void deleteProduct(Long id) { productRepository.deleteProductById(id);}

}
