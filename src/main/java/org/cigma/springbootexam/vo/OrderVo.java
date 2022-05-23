package org.cigma.springbootexam.vo;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrderVo extends BaseVo {

  private ArticleVo article;

  @NotNull(message = "Ce champ est obligatoir")
  @Positive(message = "Veuillez saisir une quantité valide")
  private Long quantity;

  private String status;
}
