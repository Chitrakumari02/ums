package com.gmaurya.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ResetPasswordDto {

	@Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password should have at least 6 characters")
	private String new_password;

	//Getter and Setter
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNew_password() {
		return new_password;
	}

	public void setNew_password(String new_password) {
		this.new_password = new_password;
	}

	//Parameterized constructor
	public ResetPasswordDto(
			@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password should have at least 6 characters") String new_password) {
		super();
		this.email = email;
		this.new_password = new_password;
	}

	public ResetPasswordDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
