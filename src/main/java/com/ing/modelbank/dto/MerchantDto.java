package com.ing.modelbank.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MerchantDto {
	
	private Integer merchandtId;
	private String merchantName;
	private String product;
	private double price;
}
