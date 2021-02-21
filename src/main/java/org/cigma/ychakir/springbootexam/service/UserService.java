package org.cigma.ychakir.springbootexam.service;

import java.util.Optional;
import org.cigma.ychakir.springbootexam.model.User;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {

  Optional<User> findByUsername(String username);

  Optional<User> findByEmail(String email);

  User save(User user);

  void changePassword(User user, String password);
}
