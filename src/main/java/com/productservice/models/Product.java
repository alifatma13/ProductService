package com.productservice.models;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product extends  BaseModel{
    private String title;
    private String description;

    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Price price;

    private String image;
    @ManyToOne(optional = false)
    @JoinColumn(nullable = false)
    private Category category;
}

/*
    1          1
 Product --- Category
     M         1
 */
