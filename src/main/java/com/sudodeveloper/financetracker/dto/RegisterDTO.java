package com.sudodeveloper.financetracker.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class RegisterDTO {

  @NotBlank(message = "Name cannot be blank")
  private String username;

  @Size(min = 6, message = "Password must be at least 6 characters")
  private String password;

  @Email(message = "Email should be valid")
  @NotBlank(message = "Email cannot be blank")
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

}
