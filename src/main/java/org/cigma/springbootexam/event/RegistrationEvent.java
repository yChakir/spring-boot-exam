package org.cigma.springbootexam.event;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.cigma.springbootexam.model.User;

@Getter
@ToString
@AllArgsConstructor
public class RegistrationEvent {

  private User user;

  @Exclude
  private String password;

}