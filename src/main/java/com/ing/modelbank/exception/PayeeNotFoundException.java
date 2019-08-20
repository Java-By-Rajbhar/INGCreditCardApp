package com.ing.modelbank.exception;

import java.io.Serializable;

public class PayeeNotFoundException extends RuntimeException implements Serializable {

	private static final long serialVersionUID = 1L;

	public PayeeNotFoundException(String message) {
		super(message);
	}

}
