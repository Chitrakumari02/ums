package com.ckumari.ums.controller;

import com.ckumari.ums.dto.ForgotPasswordDto;
import com.ckumari.ums.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/forgot-password")
public class ForgotPasswordController {

    private final RegistrationService registrationService;

    public ForgotPasswordController(RegistrationService registrationService) {
		super();
		this.registrationService = registrationService;
	}

	@GetMapping
    public String showForgotPasswordPage(Model model) {
    	model.addAttribute("forgotPasswordDto",new ForgotPasswordDto());
        return "forgot-password";
    }

    @PostMapping
    public String handleForgotPassword(@ModelAttribute ForgotPasswordDto forgotPasswordDto, Model model) {
        boolean isValid = registrationService.validateSecurityQuestions(forgotPasswordDto);
        if (isValid) {
            return "redirect:/reset-password?email=" + forgotPasswordDto.getEmail();
        } else {
            model.addAttribute("error", "Invalid email or security answers");
            return "forgot-password";
        }
    }
}

