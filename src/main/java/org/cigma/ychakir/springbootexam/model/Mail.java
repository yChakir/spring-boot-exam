package org.cigma.ychakir.springbootexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Mail extends BaseModel {

  private String sender;

  private String receiver;

  private String subject;

  @Column(length = 10000)
  private String content;

  private boolean sent;

  @Enumerated(EnumType.STRING)
  private MailType type;
}