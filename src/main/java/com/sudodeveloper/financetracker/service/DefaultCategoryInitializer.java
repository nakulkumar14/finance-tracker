package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.entity.Category;
import com.sudodeveloper.financetracker.repository.CategoryRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultCategoryInitializer {
  @Autowired
  private CategoryRepository categoryRepository;

  @PostConstruct
  public void init() {
    if (categoryRepository.count() == 0) {
      List<Category> categories = List.of(new Category("Food"), new Category("Social Life"),
          new Category("Education"), new Category("Health"));
      categoryRepository.saveAll(categories);
    }
  }
}
