package com.ing.modelbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.dto.CardDetailDto;
import com.ing.modelbank.dto.CardSummryDto;
import com.ing.modelbank.entity.CardSummary;
import com.ing.modelbank.entity.CreditCard;
import com.ing.modelbank.repository.CardSummarRepository;
import com.ing.modelbank.repository.CreditCardRepository;


@Service
public class CardSummarServiceImpl implements CardSummaryService {

	@Autowired
	private CardSummarRepository cardSummarRepository;
	
	@Autowired
	private CreditCardRepository creditCardRepository;
	
	@Override
	public CardSummryDto cardSummary(Long customerId) {

		
		CardSummryDto cardSummryDto=new CardSummryDto();
		List<CardSummary> cardSummary=cardSummarRepository.findCardDetail(customerId);
		
		cardSummryDto.setCardSummary(cardSummary);
		cardSummryDto.setStatusCode(200);
		
		return cardSummryDto;
	}

	@Override
	public CardDetailDto cardDetails(Long CustomerId) {

		CardDetailDto cardDetailDto=new CardDetailDto();
		System.out.println("in service");
		CreditCard creditCard=creditCardRepository.findCustomerCardDetail(CustomerId);
		System.out.println(creditCard.getCreditCardHolderName());
		cardDetailDto.setCreditCardNumber(creditCard.getCardCardNumber());
		cardDetailDto.setCreditCardType(creditCard.getCreditCardType());
		cardDetailDto.setCreditLimit(creditCard.getCreditLimit());
		return cardDetailDto;
	}

}
