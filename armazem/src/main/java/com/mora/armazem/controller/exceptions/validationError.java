package com.mora.armazem.controller.exceptions;

import java.util.ArrayList;
import java.util.List;

public class validationError extends StandarError{
	private static final long serialVersionUID = 1L;
	
	private List<FieldMessage> errors = new ArrayList<>();

	public validationError() {
		super();
	}

	public validationError(Long timestamp, Integer status, String error, String message, String path) {
		super(timestamp, status, error, message, path);
	}

	public List<FieldMessage> getErrors() {
		return errors;
	}

	public void addError(String fildName, String message) {
		this.errors.add(new FieldMessage(fildName, message));
	}
		
}
