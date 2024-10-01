
package com.ckumari.ums.service.Interfaces;

import com.ckumari.ums.dto.ForgotPasswordDto;

public interface ForgotPasswordService {

    boolean validateSecurityQuestions(ForgotPasswordDto forgotPasswordDto);
}
