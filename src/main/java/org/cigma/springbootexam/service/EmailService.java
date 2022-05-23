package org.cigma.springbootexam.service;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.cigma.springbootexam.event.InvoiceEvent;
import org.cigma.springbootexam.event.RegistrationEvent;
import org.cigma.springbootexam.model.Mail;

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