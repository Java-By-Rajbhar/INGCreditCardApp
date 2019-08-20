package com.ing.modelbank.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.CreditCardRequestDto;
import com.ing.modelbank.dto.OtpRequestDto;
import com.ing.modelbank.dto.OtpResposnseDto;
import com.ing.modelbank.dto.PayResponseDto;
import com.ing.modelbank.service.PayServiceImpl;

@RequestMapping("/api")
@RestController
public class PayController {

	@Autowired
	PayServiceImpl payServiceImpl;

	private static final Logger logger = LoggerFactory.getLogger(PayController.class);

	@PostMapping("/pay")
	public ResponseEntity<PayResponseDto> payNow(CreditCardRequestDto creditCardRequestDto) {
		logger.info("inside payNow method of PayController class");
		PayResponseDto response = payServiceImpl.pay(creditCardRequestDto);
		return new ResponseEntity<PayResponseDto>(response, HttpStatus.OK);

	}

	@PostMapping("/validateOtp/{creditCardId}/{merchantId}")
	public ResponseEntity<OtpResposnseDto> validateOtp(@RequestBody OtpRequestDto otpRequestDto,@PathVariable Long creditCardId ,@PathVariable int merchantId) {
		logger.debug("PayeeController of ");
		OtpResposnseDto otpResposnseDto = payServiceImpl.validateOtp(otpRequestDto,creditCardId,merchantId);
		return new ResponseEntity<>(otpResposnseDto, HttpStatus.CREATED);
	}
}
