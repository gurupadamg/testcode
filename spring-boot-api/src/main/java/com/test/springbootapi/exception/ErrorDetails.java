package com.test.springbootapi.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ErrorDetails {
	private String errorCode;
	private String errorMessage;

}
