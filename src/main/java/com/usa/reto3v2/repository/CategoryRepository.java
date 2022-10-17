package com.usa.reto3v2.repository;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.repository.crudRepository.CategoryCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CategoryRepository {

 @Autowired
    private CategoryCrudRepository categoryCrudRepository;

    public <S extends Category> S save(S entity) {
        return categoryCrudRepository.save(entity);
    }

    public <S extends Category> Iterable<S> saveAll(Iterable<S> entities) {
        return categoryCrudRepository.saveAll(entities);
    }

    public Optional<Category> findById(Integer integer) {
        return categoryCrudRepository.findById(integer);
    }

    public boolean existsById(Integer integer) {
        return categoryCrudRepository.existsById(integer);
    }

    public Iterable<Category> findAll() {
        return categoryCrudRepository.findAll();
    }

    public Iterable<Category> findAllById(Iterable<Integer> integers) {
        return categoryCrudRepository.findAllById(integers);
    }

    public long count() {
        return categoryCrudRepository.count();
    }

    public void deleteById(Integer integer) {
        categoryCrudRepository.deleteById(integer);
    }

    public void delete(Category entity) {
        categoryCrudRepository.delete(entity);
    }

    public void deleteAllById(Iterable<? extends Integer> integers) {
        categoryCrudRepository.deleteAllById(integers);
    }

    public void deleteAll(Iterable<? extends Category> entities) {
        categoryCrudRepository.deleteAll(entities);
    }

    public void deleteAll() {
        categoryCrudRepository.deleteAll();
    }
}
