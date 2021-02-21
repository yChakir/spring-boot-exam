package org.cigma.ychakir.springbootexam.controller;

import java.security.Principal;
import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.service.UserService;
import org.cigma.ychakir.springbootexam.vo.ChangePasswordVo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {

  private final UserService userService;

  private final PasswordEncoder passwordEncoder;

  @ModelAttribute("changePassword")
  public ChangePasswordVo changePassword() {
    return new ChangePasswordVo();
  }

  @GetMapping("change-password")
  public String getChangePassword() {
    return "change-password";
  }

  @PostMapping("change-password")
  public String changePassword(@ModelAttribute("changePassword") @Valid ChangePasswordVo changePasswordVo, BindingResult result, Principal principal) {
    if (!changePasswordVo.getPassword().equals(changePasswordVo.getPasswordConfirmation())) {
      result.rejectValue("passwordConfirmation", null, "Le mot de passe de confirmation n'est pas valid");
    }

    if (result.hasErrors()) {
      return "change-password";
    }

    final String username = principal.getName();
    userService.findByUsername(username).ifPresent(user -> {
      final String encode = passwordEncoder.encode(changePasswordVo.getPassword());
      userService.changePassword(user, encode);
    });

    return "redirect:/users/change-password?success";
  }
}
