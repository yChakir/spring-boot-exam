package org.cigma.springbootexam.service.impl;

import static org.cigma.springbootexam.utils.PassyUtils.generatePassayPassword;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.cigma.springbootexam.event.RegistrationEvent;
import org.cigma.springbootexam.model.User;
import org.cigma.springbootexam.repository.RoleRepository;
import org.cigma.springbootexam.service.PassportService;
import org.cigma.springbootexam.service.UserService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PassportServiceImpl implements PassportService {

  private final UserService userService;

  private final RoleRepository roleRepository;

  private final PasswordEncoder passwordEncoder;

  private final ApplicationEventPublisher publisher;

  @Override
  public void register(User user) {
    final String password = generatePassayPassword();
    user.setPassword(passwordEncoder.encode(password));
    roleRepository.findByName("CLIENT").ifPresent(role -> user.setRoles(List.of(role)));
    userService.save(user);

    publisher.publishEvent(new RegistrationEvent(user, password));
  }

}
