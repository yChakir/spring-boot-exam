package org.cigma.ychakir.springbootexam.service;

import java.util.Map;
import org.cigma.ychakir.springbootexam.event.RegistrationEvent;
import org.cigma.ychakir.springbootexam.model.Mail;

public interface EmailService {

  void sendRegistrationEmail(RegistrationEvent event);

  void sendAndSave(Mail mail, Map model);
}