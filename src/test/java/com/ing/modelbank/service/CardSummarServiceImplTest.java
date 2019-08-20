package com.ing.modelbank.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ing.modelbank.dto.CardDetailDto;
import com.ing.modelbank.dto.CardSummryDto;
import com.ing.modelbank.entity.CardSummary;
import com.ing.modelbank.entity.CreditCard;
import com.ing.modelbank.entity.Customer;
import com.ing.modelbank.repository.CardSummarRepository;
import com.ing.modelbank.repository.CreditCardRepository;


@RunWith(SpringJUnit4ClassRunner.class)
public class CardSummarServiceImplTest {

	@Mock
	CardSummarRepository cardSummarRepository;
	
	@Mock
	CreditCardRepository creditCardRepository;
	
	
	@InjectMocks
	CardSummarServiceImpl cardSummarServiceImpl;
	
	@Test
	public void testcardSummary() {
		
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
		when(cardSummarRepository.findCardDetail(Mockito.anyLong())).thenReturn(carSummaryList);
		CardSummryDto cardSummryDtoActual=cardSummarServiceImpl.cardSummary(1L);
		assertEquals(1, cardSummryDtoActual.getCardSummary().size());
	
	}
	
	@Test
	public void testCardDetail()
	{
		CreditCard creditCard=new CreditCard();
		creditCard.setCardCardNumber(12345678L);
		creditCard.setCreditCardHolderName("Shashank Kumar");
		creditCard.setCreditCardId(1L);
		creditCard.setCreditCardType("GOLD");
		creditCard.setCreditLimit(100000);
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
		creditCard.setCustomer(customer);
		creditCard.setCvv(990);
		
		
		when(creditCardRepository.findCustomerCardDetail(Mockito.anyLong())).thenReturn(creditCard);
		
		CardDetailDto CardDetailDtoActual=	cardSummarServiceImpl.cardDetails(1L);
		assertEquals("GOLD", CardDetailDtoActual.getCreditCardType());
	}

}
