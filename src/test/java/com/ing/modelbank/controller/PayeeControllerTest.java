package com.ing.modelbank.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.dto.DeleteResponseDto;
import com.ing.modelbank.dto.PayeeUpdateRequestDto;
import com.ing.modelbank.dto.PayeeUpdateResponseDto;
import com.ing.modelbank.service.DeletePayeeService;
import com.ing.modelbank.service.PayeeUpdateServiceImpl;


@RunWith(SpringJUnit4ClassRunner.class)
public class PayeeControllerTest {

	@Mock
	PayeeUpdateServiceImpl payeeUpdateServiceImpl;
	
	private MockMvc mockMvc;
	@Mock
	DeletePayeeService deletePayeeService;
	
	@InjectMocks
	PayeeController payeeController;
	
	
	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(payeeController).build();

	}
	
	@Test
	public void updatePayeeTest()
	{
		//request
		PayeeUpdateRequestDto requestDto = new PayeeUpdateRequestDto();
		requestDto.setAccountNumber(12345);
		requestDto.setEmailId("pqr@gmaiml.com");
		requestDto.setPayeeName("Radhika");
		//response
		PayeeUpdateResponseDto responseDto = new PayeeUpdateResponseDto();
		responseDto.setMessage("updated");
		responseDto.setStatusCode(200);
		Mockito.when(payeeUpdateServiceImpl.updatePayee(Mockito.any())).thenReturn(responseDto);
		
		ResponseEntity<PayeeUpdateResponseDto> response  =payeeController.updatePayee(requestDto);
		
		assertEquals(200, response.getBody().getStatusCode());
	}

	@Test
	public void testDeletePayee() throws Exception {

		DeleteResponseDto deleteResponseDto=new DeleteResponseDto();
		deleteResponseDto.setMessage("Payee Deleted");
		deleteResponseDto.setStatusCode(200);
		
		Mockito.when(deletePayeeService.deletePayee(Mockito.anyLong())).thenReturn(deleteResponseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.delete("/deletePayee/1").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(1L))).andReturn();
		
		ResponseEntity<DeleteResponseDto> deleteResponseDtoActual=payeeController.deletePayee(1L);
		assertEquals("Payee Deleted", deleteResponseDtoActual.getBody().getMessage());
		
	}

	
	
	
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
