package com.productmanager.productmanager;

import com.productmanager.productmanager.model.Product;
import com.productmanager.productmanager.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/product")
@Transactional
@jakarta.transaction.Transactional
public class ProductResouce
{
    private final ProductService productService;

    public ProductResouce(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/test")
    public int webTest(){
        return productService.test();
    }
    @CrossOrigin(origins = "http://localhost:4200")
    @GetMapping("/find/all")
    public ResponseEntity<List<Product>> getAllProducts(){
        List<Product> products = productService.findAllProducts();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Product> getProductsById(@PathVariable("id")Long id){
        Product product = productService.findProductById(id);
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product){
        Product newProduct = productService.addProduct(product);
        return new ResponseEntity<>(newProduct, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Product> updateProduct(@RequestBody Product product){
        Product updateProduct = productService.updateProduct(product);
        return new ResponseEntity<>(updateProduct, HttpStatus.OK);
    }

//    @DeleteMapping("/delete/{id}")
//    public long deleteProduct(@PathVariable("id")Long id){
//        return productService.deleteProduct(id);
//    }

//    @DeleteMapping("/delete/{id}")
//    public ResponseEntity<Product> deleteProduct(@PathVariable("id")Long id){
//        Optional<Product> deleteProduct = productService.deleteProduct(id);
//        return new ResponseEntity<>(deleteProduct, HttpStatus.OK);
//    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable("id")Long id){
        productService.deleteProduct(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}

