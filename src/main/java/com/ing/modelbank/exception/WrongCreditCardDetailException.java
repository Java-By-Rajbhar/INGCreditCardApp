package com.ing.modelbank.exception;

/**
 * 
 * @author Sushil
 *
 */
public class WrongCreditCardDetailException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public WrongCreditCardDetailException(String message)
	{
		super(message);
	}

}
