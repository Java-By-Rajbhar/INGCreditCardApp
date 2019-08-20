package com.ing.modelbank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class MerchantResponseDto {

	private String merchantName;
	private String product;
	private double price;
}
