package com.mora.armazem.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.mora.armazem.services.exception.DataIntegrityViolationException;
import com.mora.armazem.services.exception.ObjectnotFoundException;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectnotFoundException.class)
	public ResponseEntity<StandarError> objectnotFoundException(ObjectnotFoundException ex,
			HttpServletRequest request){
		
		StandarError error = new StandarError(System.currentTimeMillis(), 
				HttpStatus.NOT_FOUND.value(),"Object Not Found" , 
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandarError> dataIntegrityViolationException(DataIntegrityViolationException ex,
			HttpServletRequest request){
		
		StandarError error = new StandarError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(),"Violação de Dados" , 
				ex.getMessage(), request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
		
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarError> validationError(MethodArgumentNotValidException ex,
			HttpServletRequest request){
		
		validationError errors = new validationError(System.currentTimeMillis(), 
				HttpStatus.BAD_REQUEST.value(),"Validation error" , 
				"Erro na Validação dos campos", request.getRequestURI());
		for(FieldError x : ex.getBindingResult().getFieldErrors()) {
			errors.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
}
