package com.productservice.services;

import com.productservice.ThirdPartyClient.fakestoreclient.FakeStoreClient;
import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.security.JWTObject;
import com.productservice.security.TokenValidator;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Primary
@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService{

    private FakeStoreClient fakeStoreClient;

    private TokenValidator tokenValidator;

    FakeStoreProductService(FakeStoreClient fakeStoreClient, TokenValidator tokenValidator){
        this.fakeStoreClient = fakeStoreClient;
        this.tokenValidator = tokenValidator;
    }
    @Override
    public GenericProductDto getProductByID(String authToken, Long id) throws ProductNotFoundException {
        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);
        if(jwtObjectOptional.isEmpty()){
            //reject token
            return  null;
        }
        JWTObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUserId();

        return convertToGenericProductDto(fakeStoreClient.getProductByID(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreClient.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (FakeStoreProductDto fakestoreDto:fakeStoreProductDtos) {
            genericProductDtos.add(convertToGenericProductDto(fakestoreDto));
        }
        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {

        return convertToGenericProductDto(fakeStoreClient.deleteProductById(id));
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreClient.createProduct(genericProductDto));
    }

    @Override
    public GenericProductDto updateProductById(Long id, GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreClient.updateProductById(id, genericProductDto));
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        return genericProductDto;
    }
}
