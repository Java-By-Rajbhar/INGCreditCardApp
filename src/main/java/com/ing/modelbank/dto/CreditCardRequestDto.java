package com.ing.modelbank.dto;

import lombok.Data;

/**
 * 
 * @author Sushil
 *
 */
@Data
public class CreditCardRequestDto {
	
	private long cardCardNumber;
	private String creditCardType;
	private String expiryDate;
	private int cvv;
	private String creditCardHolderName;

}
