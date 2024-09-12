package com.ckumari.ums.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
public class Registration {

    // Getters and Setters
    @Id
    private String email;
    private String password;
    private String firstName;
    private String middleName;
    private String lastName;
    private String houseNumber;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String pinCode;
    private String phoneNo;
    private String designation;

    // Add fields for security questions
    private String question1;
    private String question2;
    private String question3;

    // Default constructor
    public Registration() {}

    // Parameterized constructor
    public Registration(String email, String password, String firstName, String middleName, String lastName,
                        String houseNumber, String streetName, String city, String state, String country,
                        String pinCode, String phoneNo, String designation,
                        String question1, String question2, String question3) {
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
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
