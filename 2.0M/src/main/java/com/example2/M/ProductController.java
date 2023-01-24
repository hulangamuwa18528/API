package com.example2.M;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductRepository productRepository;

    @PostMapping(value = "/books") //add books
    public Product addProduct(@RequestBody Product product)
    {
        return productRepository.save(product);
    }

    @GetMapping(value = "/books") //view all books
    public List<Product> getAllProducts()
    {
        return productRepository.findAll();
    }

    @GetMapping(value = "/books/{proId}") //view single book
    public Product getProductById(@PathVariable String proId)
    {
        return productRepository.findProductByProductId(proId);
    }

    @DeleteMapping(value = "/books/{proId}") //delete book
    public void deleteProduct(@PathVariable String proId)
    {
        productRepository.deleteById(proId);
    }

    @PutMapping(value ="/books/{proId}" ) //update book
    public Product updateProduct(@PathVariable String proId,@RequestBody Product product)
    {
        productRepository.deleteById(proId);
        return productRepository.save(product);
    }
}
