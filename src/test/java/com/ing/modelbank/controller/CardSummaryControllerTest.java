package com.ing.modelbank.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ing.modelbank.dto.CardSummryDto;
import com.ing.modelbank.entity.CardSummary;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.service.CardSummaryService;

@RunWith(SpringJUnit4ClassRunner.class)
public class CardSummaryControllerTest {

	@Mock
	CardSummaryService cardService;
	
	@InjectMocks
	CardSummaryController cardSummaryController;
	
	
	private MockMvc mockMvc;
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(cardSummaryController).build();
	}
	
	
	@Test
	public void testCardSummary() {
       
		
		
		CardSummryDto cardSummryDto=new CardSummryDto();
		Customer customer =new Customer();
		customer.setAddress("BTM");
		customer.setAge(30L);
		customer.setCustomerId(1L);
		customer.setEmail("a@a.com");
		customer.setFirstName("shashank");
		customer.setLastName("kumar");
		customer.setLoginId("1");
		customer.setMobileNo(8970297757L);
		customer.setPan("CKL5");
		customer.setPassword("ok");
		CardSummary cardSummary=new CardSummary();
		List<CardSummary> carSummaryList=new ArrayList<>();
		cardSummary.setAmount(1000.0);
		cardSummary.setCustomer(customer);
		cardSummary.setMerchantName("AMAZON");
		cardSummary.setTransactionDate(new Date());
		cardSummary.setTransactionType("DEBIT");
		carSummaryList.add(cardSummary);
		cardSummryDto.setCardSummary(carSummaryList);
		cardSummryDto.setStatusCode(200);
		
		Mockito.when(cardService.cardSummary(Mockito.anyLong())).thenReturn(cardSummryDto);
		ResponseEntity<CardSummryDto> actual=cardSummaryController.cardSummary(1L);
		assertEquals(1, actual.getBody().getCardSummary().size());
	
	}

	@Test
	public void testCardDetail() {
		fail("Not yet implemented");
	}

public static String asJsonString(final Object obj) {
		
		try {
			return new ObjectMapper().writeValueAsString(obj);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
