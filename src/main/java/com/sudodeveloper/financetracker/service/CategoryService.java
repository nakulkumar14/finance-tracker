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

  public List<Category> getUserCategoriesIncludingGlobal(Long userId) {
    return categoryRepository.findByUserIdOrUserIsNull(userId);
  }

  public void deleteCategory(Long id) {
    Optional<Category> categoryOptional = getCategory(id);
    if (categoryOptional.isPresent()) {
      // default categories cannot be deleted
      Category category = categoryOptional.get();
      if (category.getUser() == null) {
        throw new IllegalStateException("Default categories cannot be deleted.");
      }

      // No transaction should be present for category before deletion
      String name = category.getName();
      boolean exists = transactionService.existsByCategory(name);
      if (!exists) {
        categoryRepository.deleteById(id);
      }
    }
  }
}
