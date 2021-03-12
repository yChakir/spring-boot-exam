package org.cigma.ychakir.springbootexam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "articles")
@EqualsAndHashCode(callSuper = true)
public class Article extends BaseModel {

  @Column(unique = true)
  private String reference;

  private String title;

  private String description;

  private Long quantity;

  private Double price;
}
