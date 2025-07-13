package com.data.session04.controller;

import com.data.session04.model.entity.Book;
import com.data.session04.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @GetMapping
    public String home(@RequestParam("cateBookId")String cateBookId, Model model){
        List<Book> books = bookService.getBooksByCategoryBook(cateBookId);
        model.addAttribute("books", books);
        return "book/list";
    }
}
