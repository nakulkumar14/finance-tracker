package com.sudodeveloper.financetracker.repository;

import com.sudodeveloper.financetracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByName(String username);
}
