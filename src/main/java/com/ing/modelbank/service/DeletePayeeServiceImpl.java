package com.ing.modelbank.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.DeleteResponseDto;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.exception.CustomerNotFoundException;
import com.ing.modelbank.repository.PayeeRepository;


@Service
public class DeletePayeeServiceImpl implements DeletePayeeService {

	private static final  Logger LOGGER = LoggerFactory.getLogger(DeletePayeeServiceImpl.class);
	
	
	@Autowired
	private PayeeRepository payeeRepository;
	
	
	@Override
	public DeleteResponseDto deletePayee(Long payeeId) {

		LOGGER.info("in DeletePayeeServiceImpl") ;

		DeleteResponseDto deleteResponseDto=new DeleteResponseDto();
		
		Payee payee=null;
		Optional<Payee> deletePayee=payeeRepository.findById(payeeId);
		if(deletePayee.isPresent())
		{
			payee=deletePayee.get();
			payee.setStatus("DELETED");
			payeeRepository.save(payee);
			deleteResponseDto.setMessage("Payee Deleted");
			deleteResponseDto.setStatusCode(200);
		}
		else
		{
			throw new CustomerNotFoundException("NO payee available");
		}
		
		return deleteResponseDto;
	}

}
