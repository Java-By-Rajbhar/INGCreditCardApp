package com.ing.modelbank.service;

import java.util.List;

import com.ing.modelbank.dto.TransactionDTO;
import com.ing.modelbank.dto.TransactionDetailsDTO;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Transaction;

public interface TransactionService {
	
	public TransactionDetailsDTO fundsTransfer(TransactionDTO transactionDTO);
	
    public List<Account> payee();
    
    public List<Transaction> showHistory(Long accountId);
}
