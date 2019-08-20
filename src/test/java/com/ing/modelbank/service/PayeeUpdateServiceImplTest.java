package com.ing.modelbank.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.ing.modelbank.dto.PayeeUpdateRequestDto;
import com.ing.modelbank.dto.PayeeUpdateResponseDto;
import com.ing.modelbank.entity.Payee;
import com.ing.modelbank.repository.PayeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class PayeeUpdateServiceImplTest {

	@InjectMocks
	PayeeUpdateServiceImpl payeeUpdateServiceImpl;
	
	@Mock
	PayeeRepository payeeRepository;
	Payee payee;
	PayeeUpdateRequestDto payeeUpdateRequestDto;
	@Before
	public void setData() {
		payee =  new Payee();
		payee.setAccountNumber(1000);
		payee.setPayeeName("raja");
		
		payeeUpdateRequestDto = new  PayeeUpdateRequestDto();
		payeeUpdateRequestDto.setAccountNumber(1000);
		payeeUpdateRequestDto.setEmailId("abc@gmamil.com");
		payeeUpdateRequestDto.setPayeeName("raja");
	}
	
	@Test
	public void updatePayeeTest()
	{
		Mockito.when(payeeRepository.findByAccountNumber(Mockito.anyInt())).thenReturn(payee);
		Mockito.when(payeeRepository.save(Mockito.any())).thenReturn(payee);
		PayeeUpdateResponseDto  PayeeUpdateResponseDto =	payeeUpdateServiceImpl.updatePayee(payeeUpdateRequestDto);
		assertEquals(200, PayeeUpdateResponseDto.getStatusCode());
	}
	
}
