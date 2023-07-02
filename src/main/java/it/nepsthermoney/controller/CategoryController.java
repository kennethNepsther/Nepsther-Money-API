package it.nepsthermoney.controller;

import it.nepsthermoney.entity.Category;
import it.nepsthermoney.entity.dto.request.CategoryDto;
import it.nepsthermoney.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static it.nepsthermoney.util.UriUtil.addIdToCurrentUrlPath;

@RestController
@AllArgsConstructor
@CrossOrigin(origins = "*")
@RequestMapping("/v1/category")
public class CategoryController {
    CategoryService categoryService;

    @GetMapping("/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id) {
        Category category = categoryService.findById(id);
        return ResponseEntity.ok((category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> category = categoryService.findAll();
        return ResponseEntity.ok().body(category);

    }

    @PostMapping
    public ResponseEntity<Category> create(@Valid @RequestBody CategoryDto categoryDto){
        var category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category =  categoryService.save(category);
        return ResponseEntity.created( addIdToCurrentUrlPath(category.getId())).body(category);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Category> update(@PathVariable Long id, @Valid @RequestBody CategoryDto categoryDto){
        var category = new Category();
        BeanUtils.copyProperties(categoryDto, category);
        category = categoryService.update(id, category);
        return ResponseEntity.ok().body(category);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable Long id) {
        categoryService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Category deleted");


    }
}
