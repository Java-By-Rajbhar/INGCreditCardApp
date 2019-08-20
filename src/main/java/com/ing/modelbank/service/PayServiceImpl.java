package com.ing.modelbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.ing.modelbank.dto.CreditCardRequestDto;
import com.ing.modelbank.dto.PayResponseDto;
import com.ing.modelbank.entity.CreditCard;
import com.ing.modelbank.exception.CreditCardDoesNotExistsException;
import com.ing.modelbank.exception.WrongCreditCardDetailException;
import com.ing.modelbank.repository.CreditCardRepository;

/**
 * 
 * @author Sushil
 *
 */
public class PayServiceImpl implements PayService{
	
	@Autowired
	CreditCardRepository creditCardRepository;
	private static final Logger logger  = LoggerFactory.getLogger(PayServiceImpl.class);

	@Override
	public PayResponseDto pay(long customerId, CreditCardRequestDto creditCardRequestDto) {
		logger.info("inside pay method of PayServiceImpl class");
		/* get credit card object customer id */
		
		CreditCard creditCardDetail  = creditCardRepository.findByCustomerCustomerId(customerId);
		
		if(creditCardDetail!=null)
		{
			if(creditCardDetail.getCardCardNumber().equals(creditCardRequestDto.getCardCardNumber()) && creditCardDetail.getCvv()==creditCardRequestDto.getCvv()&& creditCardDetail.getExpiryDate().equals(creditCardRequestDto.getExpiryDate())&&creditCardDetail.getCreditCardHolderName().equals(creditCardRequestDto.getCreditCardHolderName()))
			{
				/* call otp generate service to generate otp*/
				return null;
			}
			else
			{
				throw new WrongCreditCardDetailException("Please pass right credit card detials !!!! ");
			}
				
		}
		else
		{
			throw new CreditCardDoesNotExistsException("Credit card does not exist with customer id "+customerId);
		}
	}
	
	

}
