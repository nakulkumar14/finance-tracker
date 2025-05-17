package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.entity.Category;
import com.sudodeveloper.financetracker.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

  @Autowired
  private CategoryRepository categoryRepository;

  @Autowired
  private TransactionService transactionService;

  public Category saveCategory(Category category) {
    return categoryRepository.save(category);
  }

  public List<Category> getUserCategories(Long userId) {
    return categoryRepository.findByUserId(userId);
  }

  public Optional<Category> getCategory(Long id) {
    return categoryRepository.findById(id);
  }

  public void deleteCategory(Long id) {
    Optional<Category> categoryOptional = getCategory(id);
    if (categoryOptional.isPresent()) {
      Category category = categoryOptional.get();
      String name = category.getName();
      boolean exists = transactionService.existsByCategory(name);
      if (!exists) {
        categoryRepository.deleteById(id);
      }
    }
  }
}
