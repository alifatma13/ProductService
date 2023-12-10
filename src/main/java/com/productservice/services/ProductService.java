package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
     GenericProductDto getProductByID(Long id);
     List<GenericProductDto> getAllProducts();
     GenericProductDto deleteProductById(Long id);
     GenericProductDto createProduct(GenericProductDto genericProductDto);
     GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto);

}
