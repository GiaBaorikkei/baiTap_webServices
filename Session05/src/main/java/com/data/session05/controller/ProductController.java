package com.data.session05.controller;

import com.data.session05.model.entity.Product;
import com.data.session05.model.entity.dto.response.DataResponse;
import com.data.session05.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Product>>> getAllProducts() {
        return new ResponseEntity<>(
                new DataResponse<>(productService.getAllProducts(), HttpStatus.OK),
                HttpStatus.OK
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<DataResponse<Product>> getProductById(@PathVariable Long id) {
        return new ResponseEntity<>(
                new DataResponse<>(productService.getProductById(id), HttpStatus.OK),
                HttpStatus.OK
        );
    }

    @PostMapping
    public ResponseEntity<DataResponse<Product>> createProduct(@RequestBody Product product) {
        return new ResponseEntity<>(
                new DataResponse<>(productService.insertProduct(product), HttpStatus.CREATED),
                HttpStatus.CREATED
        );
    }

    @PutMapping
    public ResponseEntity<DataResponse<Product>> updateProduct(@RequestBody Product product) {
        return new ResponseEntity<>(
                new DataResponse<>(productService.updateProduct(product, product.getId()), HttpStatus.OK),
                HttpStatus.OK
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<DataResponse<Boolean>> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<>(
                new DataResponse<>(productService.deleteProduct(id), HttpStatus.NO_CONTENT),
                HttpStatus.NO_CONTENT
        );
    }

    @GetMapping(value = "/by-name/{name}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DataResponse<List<Product>>> getProductsByName(@PathVariable String name) {
        return new ResponseEntity<>(
                new DataResponse<>(productService.getProductsByName(name), HttpStatus.OK),
                HttpStatus.OK
        );
    }
}
