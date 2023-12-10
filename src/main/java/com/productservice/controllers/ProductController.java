package com.productservice.controllers;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;
import com.productservice.services.FakeStoreProductService;
import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public List<GenericProductDto> getAllProducts() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id) {
        return  productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto) {
        return productService.createProduct(genericProductDto);
    }

    @PatchMapping("/{id}")
    public GenericProductDto updateProductById(@PathVariable("id") Long id, @RequestBody GenericProductDto genericProductDto) {
        return productService.updateProductById(id, genericProductDto);
    }
}
