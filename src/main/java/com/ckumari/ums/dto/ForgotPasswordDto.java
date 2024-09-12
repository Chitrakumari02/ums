package com.ckumari.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ForgotPasswordDto {

    // Getters and Setters
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotBlank(message = "Security question 1 cannot be blank")
    private String question1;

    @NotBlank(message = "Security question 2 cannot be blank")
    private String question2;

    @NotBlank(message = "Security question 3 cannot be blank")
    private String question3;

    // Default constructor
    public ForgotPasswordDto() {
        // Default constructor for serialization/deserialization
    }

    // Parameterized constructor
    public ForgotPasswordDto(
            @Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
            @NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password should have at least 6 characters") String password,
            @NotBlank(message = "Security question 1 cannot be blank") String question1,
            @NotBlank(message = "Security question 2 cannot be blank") String question2,
            @NotBlank(message = "Security question 3 cannot be blank") String question3) {
        this.email = email;
        this.password = password;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

}
