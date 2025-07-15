package com.data.session05.service.Impl;

import com.data.session05.model.entity.Product;
import com.data.session05.repository.ProductRepository;
import com.data.session05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product insertProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy sản phẩm với id: " + id));
        product.setId(id);
        return productRepository.save(product);
    }

    @Override
    public boolean deleteProduct(Long id) {
        productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy sản phẩm với id: " + id));
        productRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return productRepository.findProductsByNameContains(name);
    }

    @Override
    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Không tìm thấy sản phẩm với id: " + id));
    }
}
