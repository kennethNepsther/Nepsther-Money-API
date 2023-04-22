package it.nepsthermoney.service.impl;

import it.nepsthermoney.entity.Category;
import it.nepsthermoney.execptions.ObjectNotFoundException;
import it.nepsthermoney.repository.CategoryRepository;
import it.nepsthermoney.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    CategoryRepository categoryRepository;
    @Override
    public Category findById(Long id) {
        Optional<Category> Category = categoryRepository.findById(id);
        return  Category.orElseThrow(() -> new ObjectNotFoundException("No category  was found with this identifier " + id));
    }

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        category.setId(null);
        category.setName(category.getName());
        return categoryRepository.save(category);
    }

    @Override
    public Category update(Long id, Category category) {
        return null;
    }

    @Override
    public void delete(Long id) {
        // TODO document why this method is empty
    }
}
