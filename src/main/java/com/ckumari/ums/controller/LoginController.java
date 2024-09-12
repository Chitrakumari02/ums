package com.ckumari.ums.controller;

import com.ckumari.ums.dto.LoginDto;
import com.ckumari.ums.service.CaptchaService;
import com.ckumari.ums.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private RegistrationService registrationService;

	@Autowired
	private CaptchaService captchaService;

	@GetMapping
	public String loginPage(Model model) {
		model.addAttribute("loginDto", new LoginDto());
		String captchaQuestion = captchaService.generateCaptcha();
		model.addAttribute("captchaQuestion", captchaQuestion);
		return "login";
	}

	@PostMapping
	public String login(@ModelAttribute LoginDto loginDto, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("captchaQuestion", captchaService.generateCaptcha());
			return "login";
		}

		// Validate CAPTCHA
		String captchaAnswer = loginDto.getCaptchaAnswer();
		try {
			int userAnswer = Integer.parseInt(captchaAnswer);
			if (!captchaService.validateCaptcha(userAnswer)) {
				model.addAttribute("error", "Incorrect CAPTCHA. Please try again.");
				model.addAttribute("captchaQuestion", captchaService.generateCaptcha());
				return "login";
			}
		} catch (NumberFormatException e) {
			model.addAttribute("error", "CAPTCHA answer is invalid. Please try again.");
			model.addAttribute("captchaQuestion", captchaService.generateCaptcha());
			return "login";
		}

		// Validate User
		boolean validUser = registrationService.validateUser(loginDto);
		if (validUser) {
			return "redirect:/home";
		}

		model.addAttribute("error", "Invalid email or password. Please try again.");
		model.addAttribute("captchaQuestion", captchaService.generateCaptcha());
		return "login";
	}
}
