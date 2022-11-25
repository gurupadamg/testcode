package com.test.springbootapi.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.test.springbootapi.constants.ProviderConstants;

@RestControllerAdvice
public class ApplicationExceptionHandler {

	@ExceptionHandler(ProviderException.class)
	public ResponseEntity<ErrorDetails> handleProviderException(ProviderException e) {
		ErrorDetails errordetails = new ErrorDetails(ProviderConstants.INTERNAL_SERVER_ERROR, e.getMessage());
		return new ResponseEntity<ErrorDetails>(errordetails, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String, String>   handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
		Map<String, String> errorMap = new HashMap<>();
		
		e.getBindingResult().getAllErrors().stream().forEach(error -> {
			errorMap.put(error.getCode(), error.getDefaultMessage());
		});
		
		return errorMap;
	}

}
