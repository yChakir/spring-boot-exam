package org.cigma.ychakir.springbootexam.vo;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePasswordVo {

  @NotEmpty(message = "Le mot de passe est obligatoire")
  private String password;

  @NotEmpty(message = "La confirmation du mot de passe est obligatoire")
  private String passwordConfirmation;
}
