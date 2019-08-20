package com.ing.modelbank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CardDetailDto {

	private Long creditCardNumber;
	private String creditCardType;
	private double creditLimit;

}
