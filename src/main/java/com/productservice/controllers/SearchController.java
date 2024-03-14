package com.productservice.controllers;

import com.productservice.dtos.GenericProductDto;
import com.productservice.dtos.SearchRequestDto;
import com.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/search", produces = { "application/json" })
public class SearchController {
    private SearchService searchService;


    SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

/*    @PostMapping
    public List<GenericProductDto> searchProducts(@RequestBody SearchRequestDto requestDto) {


        return searchService.searchProducts(requestDto.getTitle(), requestDto.getPageNumber(), requestDto.getPageSize());
    }*/

    @PostMapping
    public Page<GenericProductDto> searchProducts(@RequestBody SearchRequestDto requestDto) {
        List<GenericProductDto> genericProductDtos = searchService.searchProducts(requestDto.getTitle(),
                requestDto.getPageNumber(),
                requestDto.getPageSize(),
                requestDto.getSortParams());
        Pageable pageable = PageRequest.of(requestDto.getPageNumber(),requestDto.getPageSize());

        Page<GenericProductDto> genericProductDtoPage = new PageImpl<>(
                genericProductDtos, pageable, genericProductDtos.size()
        );

        return genericProductDtoPage;
    }
}
