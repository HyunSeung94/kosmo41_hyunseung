package com.proj4.spacepool;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AccountController {
   @RequestMapping(value = "/Join", method = RequestMethod.GET)
   public String Join(Locale locale, Model model) {
      
      return "Join";
   }
   @RequestMapping(value = "/Join2", method = RequestMethod.GET)
   public String Join2(Locale locale, Model model) {
      
      return "Join2";
   }
}
