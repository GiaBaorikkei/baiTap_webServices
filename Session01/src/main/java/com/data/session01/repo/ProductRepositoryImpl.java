package com.data.session01.repo;

import com.data.session01.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> findAll() {
        return entityManager.createQuery("SELECT p FROM Product p", Product.class).getResultList();
    }

    @Override
    public Product findById(Long id) {
        return entityManager.find(Product.class, id);
    }

    @Override
    public void save(Product product) {
        try {
            entityManager.persist(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            Product product = findById(id);
            if (product != null) {
                entityManager.remove(product);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Product product) {
        try {
            entityManager.merge(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
