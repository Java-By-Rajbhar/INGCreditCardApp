package com.ing.modelbank.exception;
/**
 * 
 * @author Sushil
 *
 */
public class CreditCardDoesNotExistsException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public CreditCardDoesNotExistsException(String message)
	{
		super(message);
	}

}
