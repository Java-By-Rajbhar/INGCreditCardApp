package com.ing.modelbank.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.controller.LoginController;
import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.dto.LoginResponseDto;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.service.LoginService;


@RunWith(SpringRunner.class)
@WebMvcTest(value = LoginController.class)

public class LoginControllerTest {

	
	@Autowired
    MockMvc mockMvc;
	
	@MockBean
	LoginService loginService;

	Customer customer;
	LoginDto loginDto;
	LoginResponseDto loginResponseDto;
	@Before
	public void init() {
		
		loginResponseDto = new LoginResponseDto();
		loginResponseDto.setMessage("login successfull");
		customer = new Customer();

		loginDto = new LoginDto();

		mockMvc = MockMvcBuilders.standaloneSetup(loginService).build();

	}

	public static String asJsonString(final Object obj) {
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	@Test
 	public void login() throws Exception {
		Mockito.when(loginService.login(loginDto)).thenReturn(loginResponseDto);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/modelbank/api/login").contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.ALL).content(asJsonString(loginResponseDto))).andReturn();

	}

}
