
package com.ckumari.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("/home-org")
    public String showHomePage() {
        return "home-org"; // Thymeleaf template for home page
    }
}
