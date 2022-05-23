package org.cigma.springbootexam.vo;

import javax.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class RoleVo extends BaseVo {

  @NotEmpty(message = "Le nom du rôle est obligatoire")
  private String name;
}
