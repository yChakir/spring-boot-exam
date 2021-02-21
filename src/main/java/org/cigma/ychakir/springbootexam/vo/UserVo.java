package org.cigma.ychakir.springbootexam.vo;

import java.util.ArrayList;
import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString.Exclude;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserVo extends BaseVo {

  @NotEmpty(message = "Le nom et prénom est obligatoire")
  private String fullName;

  @NotEmpty(message = "Le nom d'utilisateur est obligatoire")
  private String username;

  @NotEmpty(message = "L'adresse électronique est obligatoire")
  @Email(message = "L'adresse électronique doit être valid")
  private String email;

  @Exclude
  private String password;

  @NotEmpty(message = "La ville est obligatoire")
  private String city;

  @NotEmpty(message = "Le numéro de téléphone est obligatoire")
  private String tel;

  private List<RoleVo> roles = new ArrayList<>();

}
