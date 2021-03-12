package org.cigma.ychakir.springbootexam.service.impl;

import freemarker.template.Configuration;
import freemarker.template.Template;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.mail.internet.MimeMessage;
import javax.mail.util.ByteArrayDataSource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.cigma.ychakir.springbootexam.configuration.AppConstants;
import org.cigma.ychakir.springbootexam.event.InvoiceEvent;
import org.cigma.ychakir.springbootexam.event.RegistrationEvent;
import org.cigma.ychakir.springbootexam.model.Mail;
import org.cigma.ychakir.springbootexam.model.MailType;
import org.cigma.ychakir.springbootexam.model.Order;
import org.cigma.ychakir.springbootexam.repository.EmailRepository;
import org.cigma.ychakir.springbootexam.service.EmailService;
import org.cigma.ychakir.springbootexam.utils.ExcelFile;
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
  @EventListener
  public void sendInvoiceEmail(InvoiceEvent event) {
    log.debug("sendInvoiceEmail() :: event = {}", event);

    Mail mail = new Mail();
    mail.setReceiver(event.getUser().getEmail());
    mail.setSubject("Facture CIGMA Shop !");
    mail.setType(MailType.INVOICE_EMAIL);

    Map<String, Object> model = new HashMap<>();

    model.put("fullname", event.getUser().getFullName());

    final String[] headers = new String[]{"Référence", "Désignation", "Quntité", "Prix"};

    final List<String[]> data = new ArrayList<>();

    for (Order order : event.getOrders()) {
      data.add(new String[]{order.getArticle().getReference(), order.getArticle().getTitle(), order.getQuantity().toString(),
          (order.getQuantity() * order.getArticle().getPrice()) + ""});
    }

    final XSSFWorkbook workbook = ExcelFile.builder()
        .sheetName("Invoice")
        .headerFontType(ExcelFile.FontType.BOLD)
        .headers(headers)
        .data(data)
        .buildExcel();

    ByteArrayOutputStream outputStream = null;
    try {
      outputStream = new ByteArrayOutputStream();
      workbook.write(outputStream);
      final byte[] bytes = outputStream.toByteArray();

      Attachment attachment = new Attachment();
      attachment.setFileName("Invoice-CIGMA-SHOP.xlsx");
      attachment.setData(bytes);
      attachment.setType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");

      sendAndSave(mail, model, Collections.singletonList(attachment));
    } catch (IOException e) {
      log.error("error while creating invoice file", e);
    } finally {
      if (outputStream != null) {
        IOUtils.closeQuietly(outputStream);
      }
    }
  }

  public void sendAndSave(Mail mail, Map model) {
    sendAndSave(mail, model, null);
  }

  @Override
  public void sendAndSave(Mail mail, Map model, List<Attachment> attachments) {
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

      if (attachments != null) {
        for (Attachment attachment : attachments) {
          helper.addAttachment(attachment.getFileName(), new ByteArrayDataSource(attachment.getData(), attachment.getType()));
        }
      }

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
      case INVOICE_EMAIL:
        return AppConstants.INVOICE_MAIL;
      default:
        return null;
    }
  }
}