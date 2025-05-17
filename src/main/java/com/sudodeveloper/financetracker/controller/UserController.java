package com.sudodeveloper.financetracker.controller;

import com.sudodeveloper.financetracker.dto.UserDTO;
import com.sudodeveloper.financetracker.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
public class UserController {

  @Autowired
  public UserService userService;

  @GetMapping("/users/{username}")
  public ResponseEntity<UserDTO> getUser(@PathVariable("username") String username) {
    return ResponseEntity.ok(userService.getUser(username));
  }

  @PatchMapping("/users/{username}")
  public ResponseEntity<Void> updateUser(@PathVariable("username") String username, @Valid @RequestBody UserDTO userDTO) {
    userService.updateUser(username, userDTO);
    return new ResponseEntity<>(HttpStatus.OK);
  }
}
