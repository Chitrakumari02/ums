package com.ckumari.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ResetPasswordDto {

	// Fields with appropriate validation annotations
	@Email(message = "Email should be valid")
	@NotBlank(message = "Email is required")
	private String email;

	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password should have at least 6 characters")
	private String newPassword; // Renamed field

	// Parameterized constructor
	public ResetPasswordDto(
			@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password should have at least 6 characters") String newPassword) {
		this.email = email;
		this.newPassword = newPassword;
	}

	// Default constructor
	public ResetPasswordDto() {
	}
}
