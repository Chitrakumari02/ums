package com.ckumari.ums.service;

import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class CaptchaService {

    @Getter
    private String captchaQuestion;
    private int captchaAnswer;

    public String generateCaptcha() {
        Random random = new Random();
        int num1 = random.nextInt(10) + 1;
        int num2 = random.nextInt(10) + 1;
        int operation = random.nextInt(3); // 0 for addition, 1 for subtraction, 2 for multiplication

        switch (operation) {
            case 0:
                captchaQuestion = num1 + " + " + num2 + " = ?";
                captchaAnswer = num1 + num2;
                break;
            case 1:
                captchaQuestion = num1 + " - " + num2 + " = ?";
                captchaAnswer = num1 - num2;
                break;
            case 2:
                captchaQuestion = num1 + " * " + num2 + " = ?";
                captchaAnswer = num1 * num2;
                break;
        }
        return captchaQuestion;
    }

    public boolean validateCaptcha(int userAnswer) {
        return userAnswer == captchaAnswer;
    }
}
