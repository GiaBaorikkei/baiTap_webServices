package com.data.session04.service;

import com.data.session04.model.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> getBooks();
    boolean addBook(Book book);
    boolean updateBook(Book book);
    boolean deleteBook(Integer bookId);
    Book getBookById(Integer bookId);
    List<Book> getBooksByBookNameAndAuthor(String bookName, String author);
    List<Book> getBooksByCategoryBook(String bookId);
}
