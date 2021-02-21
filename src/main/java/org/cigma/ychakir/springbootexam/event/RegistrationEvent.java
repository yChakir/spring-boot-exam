package org.cigma.ychakir.springbootexam.event;

import lombok.Getter;
import lombok.ToString;
import lombok.ToString.Exclude;
import org.cigma.ychakir.springbootexam.model.User;

@Getter
@ToString
public class RegistrationEvent {

  private User user;

  @Exclude
  private String password;

  public RegistrationEvent(User user, String password) {
    this.user = user;
    this.password = password;
  }
}