package com.ing.modelbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.PayeeUpdateRequestDto;
import com.ing.modelbank.dto.PayeeUpdateResponseDto;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.exception.PayeeDoesNotExistsException;
import com.ing.modelbank.repository.PayeeRepository;
/**
 * 
 * @author Sushil
 *
 */
@Service
public class PayeeUpdateServiceImpl implements PayeeUpdateService {

	@Autowired
	PayeeRepository payeeRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(PayeeUpdateServiceImpl.class);

	/*This method is provide implementation for update payee*/
	@Override
	public PayeeUpdateResponseDto updatePayee(PayeeUpdateRequestDto payeeUpdateRequestDto) {
		logger.info("inside updatePayee method of PayeeUpdateServiceImpl class");
		/*calling payeeRepository method to get payee object*/
		Payee payee = payeeRepository.findByAccountNumber(payeeUpdateRequestDto.getAccountNumber());
		if(payee!=null)
		{
			payee.setEmailId(payeeUpdateRequestDto.getEmailId());
			payee.setPayeeName(payeeUpdateRequestDto.getPayeeName());
			logger.info("before updating payee data={}",payee);
			/* updating payee detail*/
			payeeRepository.save(payee);
			PayeeUpdateResponseDto responseDto = new PayeeUpdateResponseDto();
			responseDto.setStatusCode(HttpStatus.OK.value());
			responseDto.setMessage("Payee with id "+payee.getPayeeId()+" has updated successfully");
			return responseDto;
		}
		else
		{
			logger.error("Account number does not exist");
			throw new PayeeDoesNotExistsException("Payee with account number "+payeeUpdateRequestDto.getAccountNumber()+ " does not exists");
		}
	}

}
