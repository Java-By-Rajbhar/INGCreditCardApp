package com.ing.modelbank.service;

import com.ing.modelbank.dto.PayeeUpdateRequestDto;
import com.ing.modelbank.dto.PayeeUpdateResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface PayeeUpdateService {
	
	/* This method is use to update payee details*/
	
	public PayeeUpdateResponseDto updatePayee(PayeeUpdateRequestDto payeeUpdateRequestDto);

}
