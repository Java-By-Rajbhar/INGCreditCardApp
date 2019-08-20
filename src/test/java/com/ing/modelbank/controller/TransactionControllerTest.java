package com.ing.modelbank.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.dto.TransactionDTO;
import com.ing.modelbank.dto.TransactionDetailsDTO;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.entity.Transaction;
import com.ing.modelbank.service.TransactionService;

@RunWith(SpringJUnit4ClassRunner.class)
public class TransactionControllerTest {

	@Mock
	TransactionService TransactionService;	
	
	@InjectMocks
	TransactionController TransactionController;
	
	
	private MockMvc mockMvc;
	TransactionDTO transactionDto;
	
	@Before
	public void setUp() {
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
		mockMvc = MockMvcBuilders.standaloneSetup(TransactionController).build();
		
				

	}
	
	
	@Test
	public void testFundTransaction() throws Throwable  {
		
		TransactionDetailsDTO TransactionDetailsDTO=new TransactionDetailsDTO();
		TransactionDetailsDTO.setMessage("transaction succesful");
		TransactionDetailsDTO.setTransactionId(1L);
		TransactionDTO TransactionDTO=new TransactionDTO();
		TransactionDTO.setAmount(100.0);
		TransactionDTO.setFromAccount(1234);
		TransactionDTO.setToAccount(5678);
		Mockito.when(TransactionService.fundsTransfer(Mockito.any())).thenReturn(TransactionDetailsDTO);

		mockMvc.perform(MockMvcRequestBuilders.post("/fundTransfer").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(transactionDto))).andReturn();
		
		ResponseEntity<TransactionDetailsDTO> check=TransactionController.fundTransaction(transactionDto);
		assertEquals("transaction succesful", check.getBody().getMessage());
	
	}

	@Test
	public void testPayees() throws Exception {
		
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
		
		Mockito.when(TransactionService.payee()).thenReturn(listAcc);
		mockMvc.perform(MockMvcRequestBuilders.get("/accounts").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(" "))).andReturn();
		ResponseEntity<List<Account>> listPayee=TransactionController.payees();
		assertEquals(2, listPayee.getBody().size());
		
	}

	@Test
	public void testTransaction() throws Exception {

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

		Mockito.when(TransactionService.showHistory(1L)).thenReturn(listTxn);
		mockMvc.perform(MockMvcRequestBuilders.get("/transactions/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(" "))).andReturn();
		ResponseEntity<List<Transaction>> listTxnActual=TransactionController.transaction(1L);
		assertEquals(1, listTxnActual.getBody().size());
	}

	public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
