package com.data.session06.controller;

import com.data.session06.model.dto.response.DataResponse;
import com.data.session06.model.entity.Book;
import com.data.session06.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping
    public ResponseEntity<DataResponse<List<Book>>> getAllBooks() {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBooks(), HttpStatus.OK), HttpStatus.OK);
    }

    @GetMapping("/{bookId}")
    public ResponseEntity<DataResponse<Book>> getBookById(@PathVariable Integer bookId) {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBookById(bookId), HttpStatus.OK), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<DataResponse<Book>> createBook(@RequestBody Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.insertBook(book), HttpStatus.CREATED), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<DataResponse<Book>> updateBook(@RequestBody Book book) {
        return new ResponseEntity<>(new DataResponse<>(bookService.updateBook(book, book.getId()), HttpStatus.OK), HttpStatus.OK);
    }

    @DeleteMapping("/{bookId}")
    public ResponseEntity<?> deleteBook(@PathVariable Integer bookId) {
        return new ResponseEntity<>(new DataResponse<>(bookService.deleteBook(bookId), HttpStatus.NO_CONTENT), HttpStatus.NO_CONTENT);
    }

    @GetMapping(value = "/books-by-name/{bookName}", produces = {"application/json; charset=UTF-8"})
    public ResponseEntity<DataResponse<List<Book>>> getBooksByName(@PathVariable String bookName) {
        return new ResponseEntity<>(new DataResponse<>(bookService.getBooksByTitle(bookName), HttpStatus.OK), HttpStatus.OK);
    }
}