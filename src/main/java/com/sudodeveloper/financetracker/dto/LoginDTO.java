package com.sudodeveloper.financetracker.dto;

import jakarta.validation.constraints.NotBlank;

public class LoginDTO {
  @NotBlank(message = "Name cannot be blank")
  private String username;

  @NotBlank(message = "Name cannot be blank")
  private String password;

  public @NotBlank(message = "Name cannot be blank") String getUsername() {
    return username;
  }

  public void setUsername(@NotBlank(message = "Name cannot be blank") String username) {
    this.username = username;
  }

  public @NotBlank(message = "Name cannot be blank") String getPassword() {
    return password;
  }

  public void setPassword(@NotBlank(message = "Name cannot be blank") String password) {
    this.password = password;
  }
}
