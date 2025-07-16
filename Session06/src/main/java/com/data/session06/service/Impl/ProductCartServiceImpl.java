package com.data.session06.service.Impl;

import com.data.session06.model.entity.ProductCart;
import com.data.session06.repository.ProductCartRepository;
import com.data.session06.service.ProductCartService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductCartServiceImpl implements ProductCartService {

    private final ProductCartRepository productCartRepository;

    @Override
    public List<ProductCart> getProductCarts() {
        return productCartRepository.findAll();
    }

    @Override
    public ProductCart getProductCartById(Long id) {
        return productCartRepository.findById(id).orElse(null);
    }

    @Override
    public ProductCart createProductCart(ProductCart productCart) {
        return productCartRepository.save(productCart);
    }

    @Override
    public ProductCart updateProductCart(Long id, ProductCart productCart) {
        if (productCartRepository.existsById(id)) {
            productCart.setId(id);
            return productCartRepository.save(productCart);
        }
        return null;
    }

    @Override
    public void deleteProductCart(Long id) {
        productCartRepository.deleteById(id);
    }

    @Override
    public List<ProductCart> getProductCartsByUserId(Long userId) {
        return productCartRepository.getProductCartByUserId(userId);
    }
}

