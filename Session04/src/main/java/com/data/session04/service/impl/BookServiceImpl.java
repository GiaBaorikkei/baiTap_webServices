package com.data.session04.service.impl;

import com.data.session04.model.entity.Book;
import com.data.session04.model.entity.CategoryBook;
import com.data.session04.repository.BookRepository;
import com.data.session04.service.BookService;
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
    public boolean addBook(Book book) {
        try{
            bookRepository.save(book);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateBook(Book book) {
        bookRepository.findById(book.getBookId()).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
        try{
            bookRepository.save(book);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteBook(Integer bookId) {
        try{
            bookRepository.deleteById(bookId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public Book getBookById(Integer bookId) {
        return bookRepository.findById(bookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai book!"));
    }

    @Override
    public List<Book> getBooksByBookNameAndAuthor(String bookName, String author) {
        return bookRepository.findBooksByBookNameContainsAndAuthorContains(bookName, author);
    }

    @Override
    public List<Book> getBooksByCategoryBook(String bookId) {
        CategoryBook cateBook = new CategoryBook();
        cateBook.setCateBookId(bookId);
        return bookRepository.findBooksByCategoryBook(cateBook);
    }
}
