package org.cigma.springbootexam.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ApplicationController {

  @GetMapping("/")
  public String login() {
    return "redirect:/passport/login";
  }

  @GetMapping("home")
  public String home() {
    return "home";
  }

}
