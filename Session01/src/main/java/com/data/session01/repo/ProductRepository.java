package com.data.session01.repo;

import com.data.session01.entity.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> findAll();
    Product findById(Long id);
    void save(Product product);
    void deleteById(Long id);
    void update(Product product);
}
