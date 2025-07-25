package com.data.session04.repository;

import com.data.session04.model.entity.CategoryBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryBookRepository extends JpaRepository<CategoryBook,String> {
    List<CategoryBook> findCategoryBooksByCateBookNameContains(String categoryBookName);
}
