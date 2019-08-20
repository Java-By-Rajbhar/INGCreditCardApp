package com.ing.modelbank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PayeeRequestDTO{
	
	private String payeeName;
	private int accountNumber;
	private String emailId;
	private String ifscCode;
}