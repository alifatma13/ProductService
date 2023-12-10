package com.productservice.controllers;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;
import com.productservice.services.FakeStoreProductService;
import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    // constructor Injection
    ProductController (@Qualifier("fakeStoreProductService") ProductService productService){
        this.productService = productService;
    }

    @GetMapping("/{id}")
    public GenericProductDto getProductByID(@PathVariable("id") Long id) {
        // call the fake store productservice
        return productService.getProductByID(id);
    }

    @GetMapping
    public void getAllProducts() {

    }

    @DeleteMapping("/{id}")
    public void deleteProductById() {

    }

    public void createProduct() {

    }

    public void updateProductById() {

    }
}
