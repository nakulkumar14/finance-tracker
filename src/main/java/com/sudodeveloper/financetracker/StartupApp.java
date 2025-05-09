package com.sudodeveloper.financetracker;

import com.sudodeveloper.financetracker.entity.User;
import com.sudodeveloper.financetracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupApp implements CommandLineRunner {

  @Autowired
  private UserRepository userRepository;

  @Override
  public void run(String... args) throws Exception {
    if (userRepository.count() == 0) {
      User user = new User();
      user.setName("test user");
      user.setPassword("test password");
      user.setEmail("abc@gmail.com");
      user.setRole(User.Role.ADMIN);
      userRepository.save(user);
    }
  }
}
