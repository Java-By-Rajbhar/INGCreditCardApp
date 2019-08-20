package com.ing.modelbank.exception;
/**
 * 
 * @author Sushil
 *
 */
public class PayeeDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PayeeDoesNotExistsException(String message)
	{
		super(message);
	}

}
