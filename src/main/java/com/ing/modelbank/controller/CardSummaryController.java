package com.ing.modelbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.CardDetailDto;
import com.ing.modelbank.dto.CardSummryDto;
import com.ing.modelbank.repository.CreditCardRepository;
import com.ing.modelbank.service.CardSummaryService;

@RestController
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
@RequestMapping("/api")
public class CardSummaryController {

	@Autowired
	private CardSummaryService cardService;
	
	
	
	
	
	 @GetMapping("/cardSummary/{customerId}")
	 public ResponseEntity<CardSummryDto> cardSummary(@PathVariable Long customerId)
	 {
		 return new ResponseEntity<>(cardService.cardSummary(customerId),HttpStatus.OK);
	 }
	 
	 @GetMapping("/CardDetails/{customerId}")
	 public ResponseEntity<CardDetailDto> cardDetail(@PathVariable Long customerId)
	 {
		 
		 CardDetailDto cardDetailDto= cardService.cardDetails(customerId);
		 return new ResponseEntity<>(cardDetailDto,HttpStatus.OK);
	 }
}
