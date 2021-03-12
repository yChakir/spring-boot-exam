package org.cigma.ychakir.springbootexam.service;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.cigma.ychakir.springbootexam.event.InvoiceEvent;
import org.cigma.ychakir.springbootexam.event.RegistrationEvent;
import org.cigma.ychakir.springbootexam.model.Mail;

public interface EmailService {

  void sendRegistrationEmail(RegistrationEvent event);

  void sendInvoiceEmail(InvoiceEvent event);

  void sendAndSave(Mail mail, Map model);

  void sendAndSave(Mail mail, Map model, List<Attachment> attachments);

  @Data
  class Attachment {

    private String fileName;
    private byte[] data;
    private String type;
  }
}