package com.data.session04.service;

import com.data.session04.model.entity.CategoryBook;

import java.util.List;

public interface CategoryBookService {
    List<CategoryBook> getCategoryBooks();
    boolean insertCategoryBook(CategoryBook categoryBook);
    boolean updateCategoryBook(CategoryBook categoryBook);
    boolean deleteCategoryBookById(String cateBookId);
    CategoryBook getCategoryBookById(String cateBookId);
    List<CategoryBook> getCategoryBooksByCategoryName(String categoryName);
}
