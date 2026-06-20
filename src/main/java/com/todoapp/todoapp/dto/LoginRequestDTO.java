package com.todoapp.todoapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor


public class LoginRequestDTO {
	
	@Email(message="Enter Valid Email")
	@NotBlank(message="Email is rquired")
	private String email;
	@NotBlank(message="Password is required")
	private String password;

}
