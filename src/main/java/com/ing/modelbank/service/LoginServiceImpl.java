package com.ing.modelbank.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.dto.LoginResponseDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;

@Service
public class LoginServiceImpl implements LoginService {

	private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

	@Autowired
	AccountRepository accountRepository;

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public LoginResponseDto login(LoginDto loginDto) {
		LoginResponseDto loginResponseDto = new LoginResponseDto();
		Customer customer = customerRepository.findByLoginIdAndPassword(loginDto.getLoginId(), loginDto.getPassword());

		if (customer != null) {
			LOGGER.info("customer fetched");
			Account account = accountRepository.findByCustomer(customer.getCustomerId());
			loginResponseDto.setAccountNumber(account.getAccountNumber());
			loginResponseDto.setMessage("logged in successfully..");
			return loginResponseDto;
		} else {
			loginResponseDto.setMessage("invalid credentials");
			return loginResponseDto;
		}

	}

}
