package com.gmaurya.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmaurya.ums.dto.LoginDto;
import com.gmaurya.ums.service.RegistrationService;

@Controller
@RequestMapping("/login")
public class LoginController {

	private RegistrationService registrationService;
	
	@GetMapping
    public String loginPage(Model model) {
		model.addAttribute("loginDto",new LoginDto());
        return "login";
    }

	@PostMapping
	public String login(@ModelAttribute LoginDto loginDto, BindingResult result) {
	    if (result.hasErrors()) {
	        return "login";
	    }
	    boolean validUser = registrationService.validateUser(loginDto);
	    if (validUser) {
	        return "redirect:/home";
	    }
	    return "redirect:/login?error=true";
	}
}

