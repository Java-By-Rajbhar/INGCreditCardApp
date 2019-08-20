package com.ing.modelbank.exception;

import java.io.Serializable;

public class AccountNotFoundException extends RuntimeException implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private static final  String MESSAGE = "No Accounts Found";
	
	public AccountNotFoundException() {
		super(MESSAGE);
	}
}