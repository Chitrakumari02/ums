package com.ckumari.ums.service;

import java.util.Optional;

import com.ckumari.ums.dto.ForgotPasswordDto;
import com.ckumari.ums.dto.LoginDto;
import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.dto.ResetPasswordDto;
import com.ckumari.ums.entity.Registration;

public interface RegistrationService {
    Registration save(RegistrationDto registrationDto);
    boolean validateUser(LoginDto loginDto);
    boolean validateSecurityQuestions(ForgotPasswordDto forgotPasswordDto);
    boolean resetPassword(ResetPasswordDto resetPasswordDto);
    Optional<Registration> findById(String email);
}
