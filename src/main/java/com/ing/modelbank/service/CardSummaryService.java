package com.ing.modelbank.service;

import com.ing.modelbank.dto.CardDetailDto;
import com.ing.modelbank.dto.CardSummryDto;

public interface CardSummaryService {
	
	public CardSummryDto  cardSummary(Long CustomerId);
	
	public CardDetailDto cardDetails(Long CustomerId);

}
