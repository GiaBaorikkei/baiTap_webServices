package com.data.session04.repository;

import com.data.session04.model.entity.Book;
import com.data.session04.model.entity.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {
    List<Book> findBooksByBookNameContainsAndAuthorContains(String bookName, String author);

    List<Book> findBooksByCategoryBook(CategoryBook categoryBook);
}
