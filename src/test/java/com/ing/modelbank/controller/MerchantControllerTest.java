package com.ing.modelbank.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.dto.MerchantDto;
import com.ing.modelbank.service.MerchantServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
public class MerchantControllerTest {

  
	
	@Mock
	MerchantServiceImpl MerchantServiceImpl;
	private MockMvc mockMvc;
	
	@InjectMocks
	MerchantController merchantController;
	
	MerchantDto merchantDto;
	
	@Before
	public void setUp() {
		
		merchantDto=new MerchantDto();
		MockitoAnnotations.initMocks(this);
		this.mockMvc = MockMvcBuilders.standaloneSetup(merchantController).build();


	}
	
	@Test
	public void getAllMerchantsTest() throws Exception
	{
		mockMvc.perform(MockMvcRequestBuilders.get("/api/allMerchants").
				contentType(MediaType.APPLICATION_JSON).
				accept(MediaType.ALL).content(asJsonString(merchantDto))).
		andExpect(status().isOk());
		
	}
	
public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
}
}
