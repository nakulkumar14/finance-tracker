package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.entity.Category;
import com.sudodeveloper.financetracker.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/categories")
@Validated
public class CategoryController {

  @Autowired
  private CategoryService categoryService;

  @PostMapping
  public ResponseEntity<Category> addCategory(@Valid @RequestBody Category category) {
    return ResponseEntity.ok(categoryService.saveCategory(category));
  }

  @GetMapping("/user/{userId}")
  public ResponseEntity<List<Category>> getCategories(@PathVariable Long userId) {
    return ResponseEntity.ok(categoryService. getUserCategoriesIncludingGlobal(userId));
  }

  @GetMapping("/{id}")
  public ResponseEntity<Category> getCategory(@PathVariable Long id) {
    return categoryService.getCategory(id)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
    categoryService.deleteCategory(id);
    return ResponseEntity.noContent().build();
  }

}
