package com.ing.modelbank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.dto.CustomerDetailsDto;
import com.ing.modelbank.dto.CustomerDto;
import com.ing.modelbank.entity.Account;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.AccountRepository;
import com.ing.modelbank.repository.CustomerRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerServiceTest {

	@Autowired
	CustomerServiceImpl customerService;

	@MockBean
	AccountRepository accountRepository;

	@MockBean
	CustomerRepository customerRepository;
	
	
	
	CustomerDto customerDto = null;
	CustomerDetailsDto customerDetailsDto = null;
	Customer customer = null;
	Account account = null;
	
	@Test
	public void registerCustomerTest() {
		customerDto = new CustomerDto();
		customerDto.setFirstName("Lakshmi");
		customerDto.setEmail("mpl@gmail.com");
		customerDto.setPassword("manne123");
		customerDto.setConfirmPassword("manne123");
		
		customer = new Customer();
		customer.setCustomerId(1L);
		
		account = new Account();
		account.setAccountType("SA");
		
		customerDetailsDto = new CustomerDetailsDto();
		customerDetailsDto.setMessage("You have Successfully Registered.....");
		
		Mockito.when(customerRepository.save(Mockito.any())).thenReturn(customer);
		Mockito.when(accountRepository.save(Mockito.any())).thenReturn(account);
		
		
		assertEquals(customerDetailsDto.getMessage(), customerService.register(customerDto).getMessage());
		
	}
}
