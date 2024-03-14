package com.productservice.dtos;

import com.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

// For added layer of abstraction while connecting to API
@Getter
@Setter
public class GenericProductDto {
    private long id;
    private String title;
    private int price;
    private String category;
    private String description;
    private String image;
    private int inventoryCount;

    public static GenericProductDto from(Product product) {
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setTitle(product.getTitle());
        genericProductDto.setDescription(product.getDescription());
        //genericProductDto.setPrice(product.getPrice());
        genericProductDto.setImage(product.getImage());
        genericProductDto.setId(1);
        genericProductDto.setInventoryCount(product.getInventoryCount());
        return genericProductDto;
    }
}
