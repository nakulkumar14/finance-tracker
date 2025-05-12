package com.sudodeveloper.financetracker.repository;

import com.sudodeveloper.financetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Optional;

@RestControllerAdvice
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByName(String username);
}
