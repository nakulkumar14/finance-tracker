package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.dto.LoginDTO;
import com.sudodeveloper.financetracker.dto.LoginResponse;
import com.sudodeveloper.financetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Validated
public class LoginController {

  private final UserService userService;

  @Autowired
  public LoginController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/login")
  public ResponseEntity<LoginResponse> login(@Valid @RequestBody LoginDTO loginDTO) {
    return ResponseEntity.ok(userService.login(loginDTO.getUsername(), loginDTO.getPassword()));
  }
}
