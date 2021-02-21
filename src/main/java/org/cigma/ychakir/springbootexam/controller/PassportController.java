package org.cigma.ychakir.springbootexam.controller;

import javax.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.cigma.ychakir.springbootexam.model.User;
import org.cigma.ychakir.springbootexam.service.PassportService;
import org.cigma.ychakir.springbootexam.service.UserService;
import org.cigma.ychakir.springbootexam.vo.UserVo;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("passport")
public class PassportController {

  private final PassportService passportService;

  private final UserService userService;

  private final ModelMapper modelMapper;

  @ModelAttribute("user")
  public UserVo userVo() {
    return new UserVo();
  }

  @GetMapping({"/", "login"})
  public String login() {
    return "login";
  }

  @GetMapping("register")
  public String register() {
    return "register";
  }

  @PostMapping("register")
  public String registerUserAccount(@ModelAttribute("user") @Valid UserVo userVo, BindingResult result) {
    var optional = userService.findByUsername(userVo.getUsername());
    if (optional.isPresent()) {
      result.rejectValue("username", null, "Ce nom d'utilisateur est déjà utilisé");
    }

    optional = userService.findByEmail(userVo.getEmail());
    if (optional.isPresent()) {
      result.rejectValue("email", null, "Cette adresse électronique est déjà utilisé");
    }

    if (!userVo.getTel().matches("^(((06)|(07)|(6)|(7))[0-9]{8})$")) {
      result.rejectValue("tel", null, "Numéro invalide !");
    }

    if (result.hasErrors()) {
      return "register";
    }

    final User user = modelMapper.map(userVo, User.class);

    passportService.register(user);
    return "redirect:/passport/login?inscriptionSuccess";
  }

}
