package com.gmaurya.ums.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ForgotPasswordDto {

	@Email(message = "Email should be valid")
    @NotBlank(message = "Email is required")
	private String email;
	
	@NotBlank(message = "Password cannot be blank")
	@Size(min = 6, message = "Password should have at least 6 characters")
	private String password;
	
	@NotBlank(message = "Question 1 cannot be blank")
	private String question_1;
	
	@NotBlank(message = "Question 2 cannot be blank")
	private String question_2;
	
	@NotBlank(message = "Question 3 cannot be blank")
	private String question_3;

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

	public String getQuestion_1() {
		return question_1;
	}

	public void setQuestion_1(String question_1) {
		this.question_1 = question_1;
	}

	public String getQuestion_2() {
		return question_2;
	}

	public void setQuestion_2(String question_2) {
		this.question_2 = question_2;
	}

	public String getQuestion_3() {
		return question_3;
	}

	public void setQuestion_3(String question_3) {
		this.question_3 = question_3;
	}

	//parameterized constructor
	public ForgotPasswordDto(
			@Email(message = "Email should be valid") @NotBlank(message = "Email is required") String email,
			@NotBlank(message = "Password cannot be blank") @Size(min = 6, message = "Password should have at least 6 characters") String password,
			@NotBlank(message = "Question 1 cannot be blank") String question_1,
			@NotBlank(message = "Question 2 cannot be blank") String question_2,
			@NotBlank(message = "Question 3 cannot be blank") String question_3) {
		super();
		this.email = email;
		this.password = password;
		this.question_1 = question_1;
		this.question_2 = question_2;
		this.question_3 = question_3;
	}

	public ForgotPasswordDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
