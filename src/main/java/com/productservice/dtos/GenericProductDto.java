package com.productservice.dtos;

import lombok.Getter;
import lombok.Setter;
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
}
