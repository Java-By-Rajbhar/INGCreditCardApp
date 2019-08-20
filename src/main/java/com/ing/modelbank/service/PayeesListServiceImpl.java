package com.ing.modelbank.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.controller.AccountController;
import com.ing.modelbank.dto.ResponsePayeeDto;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.exception.PayeeNotFoundException;
import com.ing.modelbank.repository.PayeeRepository;

@Service
public class PayeesListServiceImpl implements PayeesListService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	PayeeRepository payeeRepository;
	
	
	ResponsePayeeDto responsePayeeDto;


	@Override
	public List<ResponsePayeeDto> getListOfPayees(Long accountId) {

		 LOGGER.info("inside payee details");
		 
		 List<Payee> payeeList=payeeRepository.findByUserAccountId(accountId);
		 if(payeeList.size()!=0)
		 {
		 List<ResponsePayeeDto> listResponse = new ArrayList<>();
		 for (Payee payee : payeeList) {
			 ResponsePayeeDto payeeDto  = new ResponsePayeeDto();
			 if(!(payee.getStatus().equalsIgnoreCase("DELETED")))
			 {
				 payeeDto.setPayeeId(payee.getPayeeId());
				 payeeDto.setAccountNumber(payee.getAccountNumber());
				 payeeDto.setEmailId(payee.getEmailId());
				 payeeDto.setIFSC(payee.getIFSC());
				 payeeDto.setPayeeName(payee.getPayeeName());
				 payeeDto.setStatus(payee.getStatus());
				 
				 listResponse.add(payeeDto) ;
			 }
			
		}
		return listResponse;
		 }
		 else
		 {
			 throw new PayeeNotFoundException("Payee is not available with id "+accountId);
		 }
		 
	}

 
        
}



