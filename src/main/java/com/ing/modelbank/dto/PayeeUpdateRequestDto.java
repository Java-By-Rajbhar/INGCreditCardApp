package com.ing.modelbank.dto;

import lombok.Data;
/**
 * 
 * @author Sushil
 *
 */

@Data
public class PayeeUpdateRequestDto {
	
	private Integer accountNumber;
	private String payeeName;
	private String emailId;

}
