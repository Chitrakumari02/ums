package com.gmaurya.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gmaurya.ums.dto.AdmissionDto;
import com.gmaurya.ums.service.AdmissionService;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/admission")
public class AdmissionController {
	
	private AdmissionService admissionService;
	
	public AdmissionController(AdmissionService admissionService) {
		super();
		this.admissionService = admissionService;
	}
	
	@GetMapping
	public String showAdmissionForm(Model model) {
		model.addAttribute("admission",new AdmissionDto());
		return "admission";
	}

	@PostMapping
    public String submitApplication(@Valid @ModelAttribute("admission") AdmissionDto admissionDto, 
                                  BindingResult result, 
                                  Model model) {
        if (result.hasErrors()) {
            // Return to registration form with error messages
            return "admission";
        }
        
        // If no errors, save the registration data
        admissionService.save(admissionDto);
        return "redirect:/admission?success";
    }
}
