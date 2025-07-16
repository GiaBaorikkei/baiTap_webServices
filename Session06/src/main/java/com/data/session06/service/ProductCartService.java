package com.data.session06.service;

import com.data.session06.model.entity.ProductCart;

import java.util.List;

public interface ProductCartService {
    List<ProductCart> getProductCarts();
    ProductCart getProductCartById(Long id);
    ProductCart createProductCart(ProductCart productCart);
    ProductCart updateProductCart(Long id, ProductCart productCart);
    void deleteProductCart(Long id);
    List<ProductCart> getProductCartsByUserId(Long userId);
}

