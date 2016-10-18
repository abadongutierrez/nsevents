package com.nearsoft.nsevents.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;

@Controller
public class IndexController {

   @GetMapping("/")
   public String index(Model model) {
      model.addAttribute("time", new Date());
      model.addAttribute("message", "Welcome to Spring Boot!");
      return "index";
   }
}
