package com.sudodeveloper.financetracker.service;

import com.sudodeveloper.financetracker.dto.LoginResponse;
import com.sudodeveloper.financetracker.dto.RegisterDTO;
import com.sudodeveloper.financetracker.entity.User;
import com.sudodeveloper.financetracker.exceptions.FinanceTrackerException;
import com.sudodeveloper.financetracker.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;

  public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtService jwtService) {
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.jwtService = jwtService;
  }

  public void registerUser(RegisterDTO registerDTO) {
    User user = new User();
    user.setName(registerDTO.getUsername());
    user.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
    user.setEmail(registerDTO.getEmail());
    user.setRole(User.Role.USER);
    userRepository.save(user);
  }

  public LoginResponse login(String username, String password) {
    Optional<User> optionalUser = userRepository.findByName(username);
    if (optionalUser.isPresent()) {
      User user = optionalUser.get();
      if (passwordEncoder.matches(password, user.getPassword())) {
        // Generate JWT token
        String token = jwtService.generateToken(user);
        return new LoginResponse(token, user.getName(), user.getEmail());
      }
    }
    throw new FinanceTrackerException("Invalid username or password");
  }
}
