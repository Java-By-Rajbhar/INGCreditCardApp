package com.ing.modelbank.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.dto.LoginResponseDto;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.CustomerRepository;
import com.ing.modelbank.service.LoginServiceImpl;

@RunWith(SpringRunner.class)
public class LoginServiceTest {

	@InjectMocks
	LoginServiceImpl LoginServiceImpl;

	@Mock
	CustomerRepository customerRepository;

	Customer customer;
	LoginDto loginDto;

	@Before
	public void init() {

		customer = new Customer();
		customer.setLoginId("1");
		customer.setFirstName("chandu");
		customer.setLastName("raju");
		customer.setAddress("kdp");
		customer.setAge(24L);
		customer.setCustomerId(1L);
		customer.setPassword("chandu12");
		customer.setMobileNo(1345677L);
		customer.setPan("bw1234");
		customer.setEmail("adfd@gmail.com");

		loginDto = new LoginDto();
		loginDto.setLoginId("1");
		loginDto.setPassword("chandu12");

	}

	@Test
	public void login() {

		LoginDto loginDto=new LoginDto();
		loginDto.setLoginId("1");
		loginDto.setPassword("ok");
		Mockito.when(customerRepository.findByLoginIdAndPassword(customer.getLoginId(), customer.getPassword()))
				.thenReturn(customer);
		LoginResponseDto actualValue = LoginServiceImpl.login(loginDto);
		Assert.assertEquals("invalid credentials", actualValue.getMessage());

	}
}
