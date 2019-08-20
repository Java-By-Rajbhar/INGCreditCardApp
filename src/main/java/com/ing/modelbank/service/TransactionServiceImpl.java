
package com.ing.modelbank.service;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.TransactionDTO;
import com.ing.modelbank.dto.TransactionDetailsDTO;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Transaction;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransactionServiceImpl.class);

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public TransactionDetailsDTO fundsTransfer(TransactionDTO transactionDTO) {

		LOGGER.debug("TransactionServiceImpl fund transfer");

		Transaction transactionFrom = new Transaction();
		Transaction transactionTo = new Transaction();
		TransactionDetailsDTO transactionDetailsDTO = new TransactionDetailsDTO();
		double amountDebit = 0l;
		double amountCredit = 0l;

		Account fromAccount = accountRepository.findByAccountNumber(transactionDTO.getFromAccount());
		Account toAccount = accountRepository.findByAccountNumber(transactionDTO.getToAccount());
		// from account process

		if (transactionDTO.getAmount() > 0) {
			if (transactionDTO.getAmount() < fromAccount.getBalance()) {

				amountDebit = fromAccount.getBalance() - transactionDTO.getAmount();
				fromAccount.setBalance(amountDebit);
				accountRepository.save(fromAccount);
				transactionFrom.setAmount(transactionDTO.getAmount());
				transactionFrom.setFromAccount(fromAccount.getAccountNumber());
				transactionFrom.setToAccount(toAccount.getAccountNumber());
				transactionFrom.setTransactionType("DEBIT");
				transactionFrom.setAccount(fromAccount);
				transactionFrom.setTransactionDate(LocalDate.now());
				transactionRepository.save(transactionFrom);

				// to account process
				amountCredit = toAccount.getBalance() + transactionDTO.getAmount();
				toAccount.setBalance(amountCredit);
				accountRepository.save(toAccount);
				transactionTo.setAccount(toAccount);
				transactionTo.setAmount(transactionDTO.getAmount());
				transactionTo.setFromAccount(fromAccount.getAccountNumber());
				transactionTo.setToAccount(toAccount.getAccountNumber());
				transactionTo.setTransactionDate(LocalDate.now());
				transactionTo.setTransactionType("CREDIT");
				transactionRepository.save(transactionTo);

				transactionDetailsDTO.setMessage("Transaction Successful");
				transactionDetailsDTO.setTransactionId(transactionFrom.getTransactionId());
			} else {
				transactionDetailsDTO.setMessage("transaction failed due to suffiecient balance");
				transactionDetailsDTO.setTransactionId(0L);
			}
		} else {
			transactionDetailsDTO.setMessage("transaction failed due to negative amount");
			transactionDetailsDTO.setTransactionId(0L);
		}
		return transactionDetailsDTO;
	}

	@Override
	public List<Account> payee() {
		LOGGER.debug("TransactionServiceImpl payee");
		return accountRepository.findAll();
	}

	@Override
	public List<Transaction> showHistory(Long accountID) {

		LOGGER.debug("TransactionServiceImpl showHistory");
		Pageable pagEable = PageRequest.of(0, 10);
		List<Transaction> transaction = transactionRepository.findByAccountId(accountID, pagEable);

		return transaction;
	}

}
