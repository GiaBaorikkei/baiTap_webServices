package com.data.session06.service;

import com.data.session06.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    Book insertBook(Book book);
    Book updateBook(Book book, Integer bookId);
    boolean deleteBook(Integer id);
    List<Book> getBooksByTitle(String title);
    Book getBookById(Integer id);
}