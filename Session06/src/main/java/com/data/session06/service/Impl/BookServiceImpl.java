package com.data.session06.service.Impl;

import com.data.session06.model.entity.Book;
import com.data.session06.repository.BookRepository;
import com.data.session06.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<Book> getBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Book insertBook(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book updateBook(Book book, Integer bookId) {
        bookRepository.findById(bookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
        return bookRepository.save(book);
    }

    @Override
    public boolean deleteBook(Integer id) {
        bookRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
        bookRepository.deleteById(id);
        return true;
    }

    @Override
    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitleContains(title);
    }

    @Override
    public Book getBookById(Integer id) {
        return bookRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
    }
}

