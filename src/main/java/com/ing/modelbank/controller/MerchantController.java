package com.ing.modelbank.controller;

import java.util.List;

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

import com.ing.modelbank.dto.MerchantDto;
import com.ing.modelbank.dto.MerchantResponseDto;
import com.ing.modelbank.service.MerchantService;

@RestController
@RequestMapping("/api")

@CrossOrigin(allowedHeaders = { "*", "/" }, origins = { "*", "/" })


public class MerchantController {
	
	

	@Autowired
	MerchantService merchantService;
	public static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

	@GetMapping("/allMerchants")

	public ResponseEntity<List<MerchantDto>> getAllMerchants() 
	
	{
		logger.info("inside getAllMerchants method of merchant controller class");

		ResponseEntity<List<MerchantDto>> list = merchantService.getListOfMerchants();
		return list;

	}
	

	@GetMapping("/merchant/{merchantId}")
	public ResponseEntity<MerchantResponseDto> getmerchant(@PathVariable int merchantId){
		MerchantResponseDto merchantResponseDto=merchantService.getmerchant(merchantId);
	   return new 	ResponseEntity<>( merchantResponseDto ,HttpStatus.OK);
	}
		

}
