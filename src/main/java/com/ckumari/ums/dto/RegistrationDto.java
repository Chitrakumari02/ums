package com.ckumari.ums.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistrationDto {

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

    // Default constructor
    public RegistrationDto() {}

    // Parameterized constructor
    public RegistrationDto(String firstName, String middleName, String lastName, String email, String password, 
                           String houseNumber, String streetName, String city, String state, String country, 
                           String pinCode, String phoneNo, String designation) {
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
    }

    // Getters and Setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }
}
