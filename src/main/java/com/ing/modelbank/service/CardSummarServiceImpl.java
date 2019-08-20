package com.ing.modelbank.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.modelbank.controller.PayController;
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
	
	private static final Logger logger = LoggerFactory.getLogger(CardSummarServiceImpl.class);
	
	@Override
	public CardSummryDto cardSummary(Long customerId) {

		logger.info("in card summary");
		
		CardSummryDto cardSummryDto=new CardSummryDto();
		List<CardSummary> cardSummary=cardSummarRepository.findCardDetail(customerId);
		
		cardSummryDto.setCardSummary(cardSummary);
		cardSummryDto.setStatusCode(200);
		
		return cardSummryDto;
	}

	@Override
	public CardDetailDto cardDetails(Long CustomerId) {
		
		logger.info("in cardDetails");

		CardDetailDto cardDetailDto=new CardDetailDto();
		CreditCard creditCard=creditCardRepository.findCustomerCardDetail(CustomerId);
		cardDetailDto.setCreditCardNumber(creditCard.getCardCardNumber());
		cardDetailDto.setCreditCardType(creditCard.getCreditCardType());
		cardDetailDto.setCreditLimit(creditCard.getCreditLimit());
		return cardDetailDto;
	}

}
