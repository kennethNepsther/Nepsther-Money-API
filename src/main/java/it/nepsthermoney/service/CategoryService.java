package it.nepsthermoney.service;

import it.nepsthermoney.entity.Category;

import java.util.List;

public interface CategoryService {

    Category findById(Long id);

    List<Category> findAll();

    Category save(Category category);

    Category update(Long id, Category category);

    void delete(Long id);
}
