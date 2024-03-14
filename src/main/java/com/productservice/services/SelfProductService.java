package com.productservice.services;

import com.productservice.dtos.GenericProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import com.productservice.repositories.OpenSearchProductRepository;
import com.productservice.repositories.ProductRepository;

import java.util.List;

public class SelfProductService implements  ProductService{
    private OpenSearchProductRepository openSearchProductRepository;

    private  ProductRepository productRepository;

    SelfProductService(ProductRepository productRepository, OpenSearchProductRepository openSearchProductRepository){
        this.openSearchProductRepository = openSearchProductRepository;
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductByID(String authToken, Long id) throws ProductNotFoundException {
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        Product product = new Product();
        product.setTitle(genericProductDto.getTitle());
        product.setImage(genericProductDto.getImage());
        Product savedProduct = productRepository.save(product);
        openSearchProductRepository.save(savedProduct);
        return genericProductDto;
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return null;
    }
}
