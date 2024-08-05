package com.ckumari.ums.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.service.RegistrationService;
import javax.validation.Valid;

@Controller
public class RegistrationController {

    private final RegistrationService registrationService;

    @Autowired
    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        model.addAttribute("registration", new RegistrationDto());
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("registration") @Valid RegistrationDto registrationDto,
                                      BindingResult result) {

        if (result.hasErrors()) {
            return "registration";
        }

        registrationService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
