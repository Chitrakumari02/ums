package com.ckumari.ums.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.entity.Registration;
import com.ckumari.ums.repository.RegistrationRepository;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    private final RegistrationRepository registrationRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public RegistrationServiceImpl(RegistrationRepository registrationRepository, PasswordEncoder passwordEncoder) {
        this.registrationRepository = registrationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public Registration save(RegistrationDto registrationDto) {
        Registration registration = new Registration(
            registrationDto.getEmail(),
            passwordEncoder.encode(registrationDto.getPassword()), // Encode the password
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
            registrationDto.getDesignation()
        );
        return registrationRepository.save(registration);
    }
}
