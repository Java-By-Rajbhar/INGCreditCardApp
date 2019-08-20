package com.ing.modelbank.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.modelbank.dto.ResponseAccountDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.service.AccountServiceImpl;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@InjectMocks
	AccountServiceImpl accountServiceImpl;

	@Mock
	AccountRepository accountRepository;

	ResponseAccountDto responseAccountDto;
	
	Account account;

	@Before
	public void setup() {
		responseAccountDto = new ResponseAccountDto();
		account = new Account();
		responseAccountDto.setAccountNumber(123456);
		responseAccountDto.setAccountType("saving");
		account.setAccountType("saving");
	}
	
	@Test
	public void testAccountSummary() {
		Mockito.when(accountRepository.findByAccountNumber(Mockito.anyInt())).thenReturn(account);
		ResponseAccountDto responseAccountDto = accountServiceImpl.getAccountSummary(123456);
		Assert.assertEquals( "saving",responseAccountDto.getAccountType());
	} 
}