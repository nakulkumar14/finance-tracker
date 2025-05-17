package com.sudodeveloper.financetracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;

import java.util.StringJoiner;

public class UserDTO {

  private String username;

  @Size(min = 6, message = "Password must be at least 6 characters")
  private String password;

  @Email(message = "Email should be valid")
  private String email;

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  @Override
  public String toString() {
    return new StringJoiner(", ", UserDTO.class.getSimpleName() + "[", "]")
        .add("username='" + username + "'")
        .add("password='" + password + "'")
        .add("email='" + email + "'")
        .toString();
  }
}
