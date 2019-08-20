package com.ing.modelbank.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDetailsDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Long transactionId;
	private String message;

}
