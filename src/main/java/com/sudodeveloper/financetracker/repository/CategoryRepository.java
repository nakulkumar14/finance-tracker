package com.sudodeveloper.financetracker.repository;

import com.sudodeveloper.financetracker.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
  List<Category> findByUserId(Long userId);

  List<Category> findByUserIdOrUserIsNull(Long userId);
}
