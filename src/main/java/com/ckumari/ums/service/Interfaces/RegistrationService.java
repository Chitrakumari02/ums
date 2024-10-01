package com.ckumari.ums.service.Interfaces;

import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.entity.Registration;

public interface RegistrationService {
    Registration save(RegistrationDto registrationDto);

}