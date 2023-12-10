package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;

public interface ProductService {
     GenericProductDto getProductByID(Long id);
     void getAllProducts();
     void deleteProductById();
     void createProduct();
     void updateProductById();

}
