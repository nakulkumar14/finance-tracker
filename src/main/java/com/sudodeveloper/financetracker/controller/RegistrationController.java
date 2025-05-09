package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.dto.RegisterDTO;
import com.sudodeveloper.financetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
@Validated
public class RegistrationController {

  @Autowired
  private UserService userService;

  @PostMapping
  public ResponseEntity<String> register(@Valid @RequestBody RegisterDTO registerDTO) {
    userService.registerUser(registerDTO);
    return ResponseEntity.ok("User registered successfully");
  }
}
