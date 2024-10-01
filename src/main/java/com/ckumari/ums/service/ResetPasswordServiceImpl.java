package com.ckumari.ums.service;

import java.util.Optional;

import com.ckumari.ums.service.Interfaces.ResetPasswordService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ckumari.ums.dto.ResetPasswordDto;
import com.ckumari.ums.entity.Registration;
import com.ckumari.ums.repository.RegistrationRepository;

@AllArgsConstructor
@Service
public class ResetPasswordServiceImpl implements ResetPasswordService {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public boolean resetPassword(ResetPasswordDto resetPasswordDto) {
        Optional<Registration> optionalUser = registrationRepository.findById(resetPasswordDto.getEmail());

        if (optionalUser.isPresent()) {
            Registration registration = optionalUser.get();

            String encodedNewPassword = passwordEncoder.encode(resetPasswordDto.getNew_password());

            registration.setPassword(encodedNewPassword);
            registrationRepository.save(registration);

            return true;
        }
        return false;
    }
}