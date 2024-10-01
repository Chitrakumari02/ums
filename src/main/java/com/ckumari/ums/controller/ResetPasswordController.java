package com.ckumari.ums.controller;

import com.ckumari.ums.dto.ResetPasswordDto;
import com.ckumari.ums.service.Interfaces.ResetPasswordService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@AllArgsConstructor
@Controller
@RequestMapping("/reset-password")
public class ResetPasswordController {

    private final ResetPasswordService resetPasswordService;

    @GetMapping
    public String showResetPasswordPage(@RequestParam String email, Model model) {
        ResetPasswordDto resetPasswordDto = new ResetPasswordDto();
        resetPasswordDto.setEmail(email);
        model.addAttribute("resetPasswordDto", resetPasswordDto);
        return "reset-password";
    }

    @PostMapping
    public String handleResetPassword(ResetPasswordDto resetPasswordDto, Model model) {
        boolean isReset = resetPasswordService.resetPassword(resetPasswordDto);
        if (isReset) {
            return "redirect:/login?reset=success";
        } else {
            model.addAttribute("error", "Failed to reset password.");
            return "reset-password";
        }
    }
}