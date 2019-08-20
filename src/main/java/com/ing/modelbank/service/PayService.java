package com.ing.modelbank.service;

import com.ing.modelbank.dto.CreditCardRequestDto;
import com.ing.modelbank.dto.PayResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface PayService {
	
	public PayResponseDto pay(long customerId,CreditCardRequestDto creditCardRequestDto);

}
