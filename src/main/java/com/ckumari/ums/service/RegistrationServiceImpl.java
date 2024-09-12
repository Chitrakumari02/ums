package com.ckumari.ums.service;

import java.util.Optional;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.ckumari.ums.dto.ForgotPasswordDto;
import com.ckumari.ums.dto.LoginDto;
import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.dto.ResetPasswordDto;
import com.ckumari.ums.entity.Registration;
import com.ckumari.ums.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    // Constructor injection
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, PasswordEncoder passwordEncoder) {
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Registration save(RegistrationDto registrationDto) {
        Registration registration = new Registration(
                registrationDto.getEmail(),
                passwordEncoder.encode(registrationDto.getPassword()),
                registrationDto.getFirstName(),
                registrationDto.getMiddleName(),
                registrationDto.getLastName(),
                registrationDto.getHouseNumber(),
                registrationDto.getStreetName(),
                registrationDto.getCity(),
                registrationDto.getState(),
                registrationDto.getCountry(),
                registrationDto.getPinCode(),
                registrationDto.getPhoneNo(),
                registrationDto.getDesignation(),
                registrationDto.getQuestion1(),
                registrationDto.getQuestion2(),
                registrationDto.getQuestion3()
        );
        return registrationRepository.save(registration);
    }

    @Override
    public boolean validateSecurityQuestions(ForgotPasswordDto forgotPasswordDto) {
        Optional<Registration> optionalRegistration = registrationRepository.findById(forgotPasswordDto.getEmail());
        if (optionalRegistration.isPresent()) {
            Registration registration = optionalRegistration.get();
            return registration.getQuestion1().equals(forgotPasswordDto.getQuestion1()) &&
                    registration.getQuestion2().equals(forgotPasswordDto.getQuestion2()) &&
                    registration.getQuestion3().equals(forgotPasswordDto.getQuestion3());
        }
        return false;
    }

    @Override
    public boolean resetPassword(ResetPasswordDto resetPasswordDto) {
        Optional<Registration> optionalUser = registrationRepository.findById(resetPasswordDto.getEmail());
        if (optionalUser.isPresent()) {
            Registration registration = optionalUser.get();
            String encodedNewPassword = passwordEncoder.encode(resetPasswordDto.getNewPassword());
            registration.setPassword(encodedNewPassword);
            registrationRepository.save(registration);
            return registrationRepository.findById(resetPasswordDto.getEmail())
                    .map(r -> r.getPassword().equals(encodedNewPassword))
                    .orElse(false);
        }
        return false;
    }

    @Override
    public boolean validateUser(LoginDto loginDto) {
        Optional<Registration> optionalUser = registrationRepository.findById(loginDto.getEmail());
        if (optionalUser.isPresent()) {
            Registration user = optionalUser.get();
            return passwordEncoder.matches(loginDto.getPassword(), user.getPassword());
        }
        return false;
    }

    @Override
    public Optional<Registration> findById(String email) {
        return registrationRepository.findById(email);
    }
}
