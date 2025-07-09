package com.data.session02.service;

import java.util.List;
import java.util.Optional;

public interface IService<T> {
    T save(T entity);
    Optional<T> findById(Long id);
    T update(Long id, T entity);
    void delete(Long id);
    List<T> findAll();
}
