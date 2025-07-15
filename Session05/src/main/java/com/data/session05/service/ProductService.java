package com.data.session05.service;

import com.data.session05.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();
    Product insertProduct(Product product);
    Product updateProduct(Product product, Long id);
    boolean deleteProduct(Long id);
    List<Product> getProductsByName(String name);
    Product getProductById(Long id);
}
