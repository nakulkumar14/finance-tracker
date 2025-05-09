package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.dto.RegisterDTO;
import com.sudodeveloper.financetracker.entity.User;
import com.sudodeveloper.financetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public void registerUser(RegisterDTO registerDTO) {
    User user = new User();
    user.setName(registerDTO.getUsername());
    user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
    user.setEmail(registerDTO.getEmail());
    user.setRole(User.Role.USER);
    userRepository.save(user);
  }
}
