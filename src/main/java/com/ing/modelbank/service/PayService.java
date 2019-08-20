package com.ing.modelbank.service;

import com.ing.modelbank.dto.CreditCardRequestDto;
import com.ing.modelbank.dto.OtpRequestDto;
import com.ing.modelbank.dto.OtpResposnseDto;
import com.ing.modelbank.dto.PayResponseDto;

/**
 * 
 * @author Sushil
 *
 */
public interface PayService {
	
	public PayResponseDto pay(CreditCardRequestDto creditCardRequestDto);

	public OtpResposnseDto validateOtp(OtpRequestDto otpRequestDto, Long creditCardId,int merchantId);
	
	

}
