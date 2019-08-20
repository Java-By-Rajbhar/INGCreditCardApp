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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.TransactionDTO;
import com.ing.modelbank.dto.TransactionDetailsDTO;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Transaction;
import com.ing.modelbank.service.TransactionService;

@RestController
@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RequestMapping("/api")
public class TransactionController {
	
	private static final  Logger LOGGER = LoggerFactory.getLogger(TransactionController.class);
	
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/fundTransfer")
	public ResponseEntity<TransactionDetailsDTO> fundTransaction(@RequestBody TransactionDTO transactionDto)
	{
		LOGGER.debug("TransactionController of fundTransfer");

		
		TransactionDetailsDTO transactionDetailsDTO=transactionService.fundsTransfer(transactionDto);
		
		return new ResponseEntity<>(transactionDetailsDTO,HttpStatus.OK);
		
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> payees()
	{
		LOGGER.debug("TransactionController of accounts");
		
		return new ResponseEntity<>(transactionService.payee(),HttpStatus.OK);
	}
	
	@GetMapping("/transactions/{accontId}")
	public ResponseEntity<List<Transaction>> transaction(@PathVariable Long accontId)
	{
		LOGGER.debug("TransactionController of transactionsHistory");
		
		return new ResponseEntity<>(transactionService.showHistory(accontId),HttpStatus.OK);

	}

}
