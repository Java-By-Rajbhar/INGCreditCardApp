package com.ing.modelbank.exception;

public class PasswordMissMatchException extends RuntimeException {

	private static final long serialVersionUID = -3711314875280936823L;

	public PasswordMissMatchException(String message) {
		super(message);
	}
}
