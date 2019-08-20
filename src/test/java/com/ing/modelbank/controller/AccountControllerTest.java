
package com.ing.modelbank.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import com.ing.modelbank.dto.ResponseAccountDto;
import com.ing.modelbank.service.AccountService;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountController.class)
public class AccountControllerTest {
	@Autowired
	MockMvc mockMvc;

	@MockBean
	AccountService accountService;

	ResponseAccountDto responseAccountDto;

	@Before
	public void setup() {
		responseAccountDto = new ResponseAccountDto();
		responseAccountDto.setAccountNumber(123456);
	}

	@Test
	public void testAccountSummary() throws Exception {
		Mockito.when(accountService.getAccountSummary(Mockito.anyInt())).thenReturn(responseAccountDto);
		mockMvc.perform(MockMvcRequestBuilders.get("/api/accountSummary/123456").contentType(MediaType.APPLICATION_JSON)
				.content(asJsonString(responseAccountDto))).andExpect(MockMvcResultMatchers.status().isOk());
	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}