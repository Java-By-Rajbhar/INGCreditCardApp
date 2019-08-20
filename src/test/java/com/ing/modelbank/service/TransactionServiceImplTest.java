package com.ing.modelbank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.modelbank.dto.TransactionDTO;
import com.ing.modelbank.dto.TransactionDetailsDTO;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.Transaction;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.repository.TransactionRepository;

@RunWith(MockitoJUnitRunner.class)
public class TransactionServiceImplTest {

	@Mock
	private AccountRepository accountRepository;

	@Mock
	private CustomerRepository customerRepository;

	@Mock
	private TransactionRepository transactionRepository;
	
	@InjectMocks
	private TransactionServiceImpl transactionServiceImpl;
	
	
	
	
	
	@Test
	public void testFundsTransfer() {
		
		double amount =10;
		Account AccountFrom=new Account();
		AccountFrom.setAccountId(1L);
		AccountFrom.setAccountNumber(1234);
		AccountFrom.setAccountType("SBA");
		AccountFrom.setBalance(1000.0);	
		Customer customerFrom=new Customer();
		customerFrom.setAddress("BTM");
		customerFrom.setAge(23L);
		customerFrom.setCustomerId(1L);
		customerFrom.setEmail("a@a.com");
		customerFrom.setFirstName("shashank");
		customerFrom.setLastName("kumar");
		customerFrom.setLoginId("1234");
		customerFrom.setPan("CKL5");
		customerFrom.setPassword("ok");
		

		Account AccountTo=new Account();
		AccountTo.setAccountId(1L);
		AccountTo.setAccountNumber(1234);
		AccountTo.setAccountType("SBA");
		AccountTo.setBalance(1000.0);	
		Customer customerTo=new Customer();
		customerTo.setAddress("BTM");
		customerTo.setAge(23L);
		customerTo.setCustomerId(1L);
		customerTo.setEmail("a@a.com");
		customerTo.setFirstName("shashank");
		customerTo.setLastName("kumar");
		customerTo.setLoginId("1234");
		customerTo.setPan("CKL5");
		customerTo.setPassword("ok");
		AccountFrom.setCustomer(customerTo);
		
		TransactionDTO TransactionDetailsDTO=new TransactionDTO();
		TransactionDetailsDTO.setAmount(100.0);
		TransactionDetailsDTO.setFromAccount(1234);
		TransactionDetailsDTO.setToAccount(5678);
		
		when(accountRepository.findByAccountNumber(Mockito.anyInt())).thenReturn(AccountFrom);
		when(accountRepository.findByAccountNumber(Mockito.anyInt())).thenReturn(AccountTo);
		
		TransactionDetailsDTO dtoRes=transactionServiceImpl.fundsTransfer(TransactionDetailsDTO);
		assertEquals("Transaction Successful", dtoRes.getMessage());
	}

	@Test
	public void testPayee() {
		
		double amount =10;
		Account AccountFrom=new Account();
		AccountFrom.setAccountId(1L);
		AccountFrom.setAccountNumber(1234);
		AccountFrom.setAccountType("SBA");
		AccountFrom.setBalance(1000.0);	
		Customer customerFrom=new Customer();
		customerFrom.setAddress("BTM");
		customerFrom.setAge(23L);
		customerFrom.setCustomerId(1L);
		customerFrom.setEmail("a@a.com");
		customerFrom.setFirstName("shashank");
		customerFrom.setLastName("kumar");
		customerFrom.setLoginId("1234");
		customerFrom.setPan("CKL5");
		customerFrom.setPassword("ok");
		

		Account AccountTo=new Account();
		AccountTo.setAccountId(1L);
		AccountTo.setAccountNumber(1234);
		AccountTo.setAccountType("SBA");
		AccountTo.setBalance(1000.0);	
		Customer customerTo=new Customer();
		customerTo.setAddress("BTM");
		customerTo.setAge(23L);
		customerTo.setCustomerId(1L);
		customerTo.setEmail("a@a.com");
		customerTo.setFirstName("shashank");
		customerTo.setLastName("kumar");
		customerTo.setLoginId("1234");
		customerTo.setPan("CKL5");
		customerTo.setPassword("ok");
		AccountFrom.setCustomer(customerTo);
		List<Account> listAcc=new ArrayList<>();
		listAcc.add(AccountTo);
		listAcc.add(AccountFrom);
		
		when(accountRepository.findAll()).thenReturn(listAcc);
		List<Account> actual=transactionServiceImpl.payee();
		assertEquals(2, actual.size());
	}

	@Test
	public void testShowHistory() {
		Account AccountFrom=new Account();
		AccountFrom.setAccountId(1L);
		AccountFrom.setAccountNumber(1234);
		AccountFrom.setAccountType("SBA");
		AccountFrom.setBalance(1000.0);	
		Customer customerFrom=new Customer();
		customerFrom.setAddress("BTM");
		customerFrom.setAge(23L);
		customerFrom.setCustomerId(1L);
		customerFrom.setEmail("a@a.com");
		customerFrom.setFirstName("shashank");
		customerFrom.setLastName("kumar");
		customerFrom.setLoginId("1234");
		customerFrom.setPan("CKL5");
		customerFrom.setPassword("ok");
		Transaction Transaction=new Transaction();
		Transaction.setAccount(AccountFrom);
		Transaction.setAmount(1000.00);
		Transaction.setFromAccount(1234);
		Transaction.setToAccount(5678);
		Transaction.setTransactionDate(LocalDate.now());
		Transaction.setTransactionId(1L);
		Transaction.setTransactionType("DEBIT");
		List<Transaction> listTxn=new ArrayList<>();
		listTxn.add(Transaction);
		
		when(transactionRepository.findByAccountId(Mockito.anyLong(), Mockito.any())).thenReturn(listTxn);
		
		List<Transaction> listTxnActual=transactionServiceImpl.showHistory(1L);
		assertEquals(1, listTxnActual.size());
	}

}
