package com.ing.modelbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.MerchantResponseDto;
import com.ing.modelbank.service.MerchantService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
public class MerchantController {
	
	@Autowired
	MerchantService merchantService;
	
	@GetMapping("/merchant/{merchantId}")
	public ResponseEntity<MerchantResponseDto> getmerchant(@PathVariable int merchantId){
		MerchantResponseDto merchantResponseDto=merchantService.getmerchant(merchantId);
	   return new 	ResponseEntity<>( merchantResponseDto ,HttpStatus.OK);
	}
		
	

}
