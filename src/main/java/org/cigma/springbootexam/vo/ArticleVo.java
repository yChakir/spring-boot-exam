package org.cigma.springbootexam.vo;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ArticleVo extends BaseVo {

  @NotEmpty(message = "Ce champ est obligatoir")
  private String reference;

  @NotEmpty(message = "Ce champ est obligatoir")
  private String title;

  private String description;

  @NotNull(message = "Ce champ est obligatoir")
  @Positive(message = "Veuillez saisir une quantité valide")
  private Long quantity;

  @NotNull(message = "Ce champ est obligatoir")
  @PositiveOrZero(message = "Veuillez saisir un prix valide")
  private Double price;
}
