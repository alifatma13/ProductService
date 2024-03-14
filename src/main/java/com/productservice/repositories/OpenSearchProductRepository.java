package com.productservice.repositories;

import com.productservice.models.Product;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface OpenSearchProductRepository extends ElasticsearchRepository<Product,Long> {

    Iterable<Product> findAll();

    List<Product> findAllByTitle(String title);
    Optional<Product> findById(Long productId);

    Product save(Product product);

    List<Product> findAllByTitleContaining(String title, PageRequest pageRequest);
}
