package com.ing.modelbank.dto;

import java.io.Serializable;
import java.util.List;

import com.ing.modelbank.entity.CardSummary;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardSummryDto implements Serializable{

	private static final long serialVersionUID = 8610320364370157270L;
	
	private Integer statusCode;
	private List<CardSummary> cardSummary;
	
	
}
