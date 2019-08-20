package com.ing.modelbank.controller;

import org.slf4j.Logger;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.CustomerDetailsDto;
import com.ing.modelbank.dto.CustomerDto;
import com.ing.modelbank.service.ICustomerService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
public class CustomerController {

	private static final  Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	ICustomerService customerService;
	
	@PostMapping("/register")
	public ResponseEntity<CustomerDetailsDto> register(@RequestBody CustomerDto customerDto){
		LOGGER.debug("CustomerController of ");
		CustomerDetailsDto customerDetailsDto = customerService.register(customerDto);
		return new ResponseEntity<>(customerDetailsDto,HttpStatus.CREATED);
	}
}
