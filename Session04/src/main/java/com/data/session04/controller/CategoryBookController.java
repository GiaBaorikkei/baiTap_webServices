package com.data.session04.controller;

import com.data.session04.model.entity.CategoryBook;
import com.data.session04.service.CategoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/category")
public class CategoryBookController {
    @Autowired
    private CategoryBookService categoryBookService;

    @GetMapping
    public String home(Model model){
        List<CategoryBook> categoryBooks = categoryBookService.getCategoryBooks();
        model.addAttribute("categoryBooks", categoryBooks);
        return "category/load";
    }
    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("c", new CategoryBook());
        return "category/add";
    }

    @PostMapping("/save")
    public String save(CategoryBook cateBook){
        categoryBookService.insertCategoryBook(cateBook);
        return "redirect:/category";
    }
}
