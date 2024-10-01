package com.ckumari.ums.service.Interfaces;

import java.util.Optional;

import com.ckumari.ums.dto.LoginDto;
import com.ckumari.ums.entity.Registration;

public interface LoginService {

    //boolean validateUser(LoginDto loginDto, String captchaAnswer, String captchaExpected);
    //Optional<Registration> findById(String email);

    //boolean validateUser(LoginDto loginDto);

    boolean validateUser(String email, String password);
    String getProfileByEmail(String email);
    Optional<Registration> findByEmail(String email);

}