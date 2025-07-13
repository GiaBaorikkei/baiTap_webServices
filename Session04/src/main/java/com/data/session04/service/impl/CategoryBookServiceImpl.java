package com.data.session04.service.impl;

import com.data.session04.model.entity.CategoryBook;
import com.data.session04.repository.CategoryBookRepository;
import com.data.session04.service.CategoryBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CategoryBookServiceImpl implements CategoryBookService {
    @Autowired
    private CategoryBookRepository categoryBookRepository;

    @Override
    public List<CategoryBook> getCategoryBooks() {
        return categoryBookRepository.findAll();
    }

    @Override
    public boolean insertCategoryBook(CategoryBook categoryBook) {
        try{
            categoryBookRepository.save(categoryBook);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean updateCategoryBook(CategoryBook categoryBook) {
        categoryBookRepository.findById(categoryBook.getCateBookId()).orElseThrow(()-> new NoSuchElementException("Khong ton tai category book!"));
        try{
            categoryBookRepository.save(categoryBook);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean deleteCategoryBookById(String cateBookId) {
        try{
            categoryBookRepository.deleteById(cateBookId);
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public CategoryBook getCategoryBookById(String cateBookId) {
        return categoryBookRepository.findById(cateBookId).orElseThrow(()-> new NoSuchElementException("Khong ton tai category book!"));
    }

    @Override
    public List<CategoryBook> getCategoryBooksByCategoryName(String categoryName) {
        return categoryBookRepository.findCategoryBooksByCateBookNameContains(categoryName);
    }
}
