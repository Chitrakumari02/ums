package com.ckumari.ums.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Setter
@Getter
public class RegistrationDto {

    // Getters and Setters
    @NotBlank(message = "First name is required")
    private String firstName;

    private String middleName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank(message = "Password is required")
    @Size(min = 6, message = "Password should have at least 6 characters")
    private String password;

    @NotBlank(message = "House number/building name is required")
    private String houseNumber;

    @NotBlank(message = "Street name/area/locality is required")
    private String streetName;

    @NotBlank(message = "City/town/village is required")
    private String city;

    @NotBlank(message = "State is required")
    private String state;

    @NotBlank(message = "Country is required")
    private String country;

    @Size(min = 6, max = 6, message = "Pin code must be exactly 6 digits")
    @Pattern(regexp = "\\d{6}", message = "Pin code must be exactly 6 digits")
    private String pinCode;

    @NotNull(message = "Phone number is required")
    @Pattern(regexp = "^[6-9]\\d{9}$", message = "Phone number should be exactly 10 digits and start with 6, 7, 8, or 9")
    private String phoneNo;

    private String designation;

    // Add fields for security questions
    @NotBlank(message = "Security question 1 is required")
    private String question1;

    @NotBlank(message = "Security question 2 is required")
    private String question2;

    @NotBlank(message = "Security question 3 is required")
    private String question3;

    // Default constructor
    public RegistrationDto() {}

    // Parameterized constructor
    public RegistrationDto(String firstName, String middleName, String lastName, String email, String password,
                           String houseNumber, String streetName, String city, String state, String country,
                           String pinCode, String phoneNo, String designation,
                           String question1, String question2, String question3) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.houseNumber = houseNumber;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.phoneNo = phoneNo;
        this.designation = designation;
        this.question1 = question1;
        this.question2 = question2;
        this.question3 = question3;
    }

}
