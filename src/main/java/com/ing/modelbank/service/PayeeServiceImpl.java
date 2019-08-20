package com.ing.modelbank.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ing.modelbank.dto.PayeeOtpRequestDto;
import com.ing.modelbank.dto.PayeeOtpResponseDTO;
import com.ing.modelbank.dto.PayeeRequestDTO;
import com.ing.modelbank.dto.PayeeResponseDTO;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.entity.PayeeOtp;
import com.ing.modelbank.exception.CustomerNotFoundException;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.repository.PayeeOtpRepository;
import com.ing.modelbank.repository.PayeeRepository;

@Service
@Transactional
public class PayeeServiceImpl implements PayeeService{

	@Autowired
	PayeeRepository payeeRepository;
	
	@Autowired
	PayeeOtpRepository payeeOtpRepository;
	
	
	@Autowired
	CustomerRepository customerRepository;
	
	@Autowired
	MailService mailService;

	
	public PayeeResponseDTO addPayee(PayeeRequestDTO payeeRequestDTO, long customerId) {
		Payee payee = new Payee();
		 Optional<Customer> customerrepo =customerRepository.findById(customerId); 
		 Customer customer=null;
		if(customerrepo.isPresent()){
		 customer=customerrepo.get();
		}
		
		Random rand = new Random();
		long otp=1000+rand.nextInt(9999);
		
		BeanUtils.copyProperties(payeeRequestDTO, payee);
		payee.setStatus("PENDING");
		payeeRepository.save(payee);
		mailService.sendEmail(customer.getEmail(), payee.getPayeeId(),payee.getAccountNumber(),otp);
		
		PayeeOtp payeeOtp = new PayeeOtp();
		payeeOtp.setOtp(otp);
		payeeOtp.setPayeeId(payee.getPayeeId());
		payeeOtpRepository.save(payeeOtp);
		

		PayeeResponseDTO payeeResponseDTO=new PayeeResponseDTO();
		payeeResponseDTO.setMessage("Payee Pending Verification");
		payeeResponseDTO.setPayeeId(payee.getPayeeId());

		return payeeResponseDTO;
	}

	
	
	public PayeeOtpResponseDTO validateOtp(PayeeOtpRequestDto payeeOtpRequestDto, Long payeeId) {
		Payee payee= payeeRepository.findByPayeeId(payeeId);
			
		  PayeeOtp payeeotp=payeeOtpRepository.findByOtpAndPayeeId(payeeOtpRequestDto.getOtp(),payeeId);
		 
		  PayeeOtpResponseDTO payeeOtpResponseDTO = new PayeeOtpResponseDTO();
		  if(payeeotp==null ) {
			  throw new CustomerNotFoundException("Invalid Credentials"); }
		  
		  
	else {
		  payeeOtpResponseDTO.setMessage("Payee Added Successfully");
		  payee.setStatus("Active");
		  payeeRepository.save(payee);
		return payeeOtpResponseDTO;
	}
	 
	
	

	}}




