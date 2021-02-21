package org.cigma.ychakir.springbootexam.service.impl;

import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.model.User;
import org.cigma.ychakir.springbootexam.repository.UserRepository;
import org.cigma.ychakir.springbootexam.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return userRepository.findByUsername(username).orElseThrow();
  }

  @Override
  public Optional<User> findByUsername(String username) {
    return userRepository.findByUsername(username);
  }

  @Override
  public Optional<User> findByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public User save(User user) {
    return userRepository.save(user);
  }

  @Override
  public void changePassword(User user, String password) {
    user.setPassword(password);
    userRepository.save(user);
  }
}
