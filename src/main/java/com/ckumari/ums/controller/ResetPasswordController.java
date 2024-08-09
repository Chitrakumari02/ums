//package com.gmaurya.ums.controller;
//
//import com.gmaurya.ums.dto.ResetPasswordDto;
//import com.gmaurya.ums.service.RegistrationService;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//
//@Controller
//@RequestMapping("/reset-password")
//public class ResetPasswordController {
//
//    private RegistrationService registrationService;
//
//    public ResetPasswordController(RegistrationService registrationService) {
//		super();
//		this.registrationService = registrationService;
//	}
//
//    @GetMapping
//    public String showResetPasswordPage(@RequestParam String email, Model model) {
//        model.addAttribute("email", email);
//        model.addAttribute("resetPasswordDto", new ResetPasswordDto());
//        return "reset-password";
//    }
//
//    @PostMapping
//    public String handleResetPassword(@RequestParam String email,@RequestParam String newPassword, Model model) {
//        
//    	ResetPasswordDto resetPasswordDto=new ResetPasswordDto();
//    	resetPasswordDto.setEmail(email);
//    	resetPasswordDto.setNew_password(newPassword);
//    	
//    	boolean isReset = registrationService.resetPassword(resetPasswordDto);
//        
//        if (isReset) {
//            // Redirect to the login page with a success parameter
//            return "redirect:/login?reset=true";
//        } else {
//            // Add an error message to the model and return to the reset-password page
//            model.addAttribute("error", "Failed to reset password");
//            return "reset-password";
//        }
//    }
//}

package com.gmaurya.ums.controller;

import com.gmaurya.ums.dto.ResetPasswordDto;
import com.gmaurya.ums.service.RegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/reset-password")
public class ResetPasswordController {

    private final RegistrationService registrationService;

    public ResetPasswordController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @GetMapping
    public String showResetPasswordPage(@RequestParam String email, Model model) {
        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
        resetPasswordDto.setEmail(email);
        model.addAttribute("resetPasswordDto", resetPasswordDto);
        return "reset-password";
    }

    @PostMapping
    public String handleResetPassword(ResetPasswordDto resetPasswordDto, Model model) {
        boolean isReset = registrationService.resetPassword(resetPasswordDto);
        if (isReset) {
            return "redirect:/login?reset=success";
        } else {
            model.addAttribute("error", "Failed to reset password.");
            return "reset-password";
        }
    }
}
