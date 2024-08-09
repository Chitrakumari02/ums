package com.gmaurya.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class LoginDto {
	
	@Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password should have at least 6 characters")
	private String password;

	//Getter and Setter
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

	//Parameterized constructor
	public LoginDto(@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password should have at least 6 characters") String password) {
		super();
		this.email = email;
		this.password = password;
	}

	public LoginDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
