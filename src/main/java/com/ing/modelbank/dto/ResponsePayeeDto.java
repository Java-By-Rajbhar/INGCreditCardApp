package com.ing.modelbank.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponsePayeeDto {
	private Long payeeId;
	private String payeeName;
	private Integer accountNumber ;
	private String emailId;
	private String IFSC;
	private String status;

}
