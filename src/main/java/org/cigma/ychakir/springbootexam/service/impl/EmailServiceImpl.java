package org.cigma.ychakir.springbootexam.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.cigma.ychakir.springbootexam.configuration.AppConstants;
import org.cigma.ychakir.springbootexam.event.RegistrationEvent;
import org.cigma.ychakir.springbootexam.model.Mail;
import org.cigma.ychakir.springbootexam.model.MailType;
import org.cigma.ychakir.springbootexam.repository.EmailRepository;
import org.cigma.ychakir.springbootexam.service.EmailService;
import org.springframework.context.event.EventListener;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

  private final JavaMailSender sender;

  private final EmailRepository emailRepository;

  private final Configuration freeMarkerConfiguration;

  @Override
  @EventListener
  public void sendRegistrationEmail(RegistrationEvent event) {
    log.debug("sendRegistrationEmail() :: event = {}", event);

    Mail mail = new Mail();
    mail.setReceiver(event.getUser().getEmail());
    mail.setSubject("Bienvenu sur CIGMA Shop !");
    mail.setType(MailType.REGISTRATION_EMAIL);

    Map<String, Object> model = new HashMap<>();

    model.put("fullname", event.getUser().getFullName());
    model.put("username", event.getUser().getUsername());
    model.put("password", event.getPassword());

    sendAndSave(mail, model);
  }

  @Override
  public void sendAndSave(Mail mail, Map model) {
    log.debug("sendAndSave() :: mail = {}, model = {}", mail.getType(), model);
    try {
      log.debug("sendAndSave() :: building the message...");
      MimeMessage message = sender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message,
          MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED,
          StandardCharsets.UTF_8.name());

      String templateName = getTemplateNameByMailType(mail.getType());
      Template template = freeMarkerConfiguration.getTemplate(templateName);
      String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

      mail.setContent(html);
      mail.setSent(true);

      helper.setTo(mail.getReceiver());
      helper.setSubject(mail.getSubject());
      helper.setText(html, true);

      log.debug("sendAndSave() :: Sending...");
      sender.send(message);
    } catch (Exception e) {
      log.error("sendAndSave() :: error while sending mail = {}, message = {}", mail.getType(),
          e.getMessage());
      mail.setSent(false);
    } finally {
      emailRepository.save(mail);
      log.debug("sendAndSave() :: Email sent = {}", mail.isSent());
    }
  }

  private String getTemplateNameByMailType(MailType type) {
    switch (type) {
      case REGISTRATION_EMAIL:
        return AppConstants.REGISTRATION_MAIL;
      default:
        return null;
    }
  }
}