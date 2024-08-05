package com.ckumari.ums.service;
import com.ckumari.ums.dto.RegistrationDto;
import com.ckumari.ums.entity.Registration;

public interface RegistrationService{
	Registration save(RegistrationDto registrationDto);
}
