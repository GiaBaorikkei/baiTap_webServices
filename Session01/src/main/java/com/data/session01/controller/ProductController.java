package com.data.session01.controller;

import com.data.session01.entity.Product;
import com.data.session01.repo.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository productRepo;

    public ProductController(ProductRepository productRepository) {
        this.productRepo = productRepository;
    }

    @GetMapping
    public String products(Model model) {
        model.addAttribute("products", productRepo.findAll());
        return "list";
    }

    @GetMapping("/add")
    public String ShowAddProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "add";
    }

    @PostMapping("/add")
    public String addProduct(@ModelAttribute Product product) {
        productRepo.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productRepo.deleteById(id);
        return "redirect:/products";
    }

    @GetMapping("/update/{id}")
    public String showUpdateProductForm(@PathVariable("id") Long id, Model model) {
        Product product = productRepo.findById(id);
        if (product != null) {
            model.addAttribute("product", product);
            return "update";
        }
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@ModelAttribute Product product) {
        productRepo.update(product);
        return "redirect:/products";
    }

}
