package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll() {
        return categoryRepository.getAll();
    }
    //public List<Category> getAll(){
    //return categoryRepository.getAll();
    //}
    public Category get(Integer id) {
        return categoryRepository.getCategory(id).get();
    }
    public Optional<Category> getCategory(int id) {
        return categoryRepository.getCategory(id);
    }

    public Category save(Category categoria) {
        if (categoria.getId() == null) {
            return categoryRepository.save(categoria);
        } else {
            Optional<Category> c = categoryRepository.getCategory(categoria.getId());
            if (c.isPresent()) {
                return categoria;
            } else {
                return categoryRepository.save(categoria);
            }
        }
    }

    public Category update(Category categoria) {
        if (categoria.getId() != null) {
            Optional<Category> ct = categoryRepository.getCategory(categoria.getId());
            if (ct.isPresent()) {
                if (categoria.getName() != null) {
                    ct.get().setName(categoria.getName());
                }
                if (categoria.getDescription() != null) {
                    ct.get().setDescription(categoria.getDescription());
                }
                if (categoria.getMotorbikes() != null) {
                    ct.get().setMotorbikes(categoria.getMotorbikes());
                }
                categoryRepository.save(ct.get());
                return ct.get();
            } else {
                return categoria;
            }
        } else {
            return categoria;
        }
    }

    public boolean delete(int id) {
        boolean marca = false;
        Optional<Category> ctr = categoryRepository.getCategory(id);
        if (ctr.isPresent()) {
            categoryRepository.delete(ctr.get());
            marca = true;
        }
        return marca;
    }
}
