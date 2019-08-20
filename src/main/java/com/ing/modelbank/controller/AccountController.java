package com.ing.modelbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.ResponseAccountDto;
import com.ing.modelbank.service.AccountService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })
@RequestMapping("/api")
public class AccountController {

	private static final  Logger LOGGER = LoggerFactory.getLogger(AccountController.class);

	@Autowired
	AccountService accountService;

	@GetMapping("/accountSummary/{accountNumber}")
	public ResponseEntity<ResponseAccountDto> getAccountSummary(@PathVariable("accountNumber") Integer accountNumber) {
		LOGGER.info("inside accountcontroller... ");

		ResponseAccountDto responseAccountDto = accountService.getAccountSummary(accountNumber);
		return new ResponseEntity<>(responseAccountDto, HttpStatus.OK);
	}

}




