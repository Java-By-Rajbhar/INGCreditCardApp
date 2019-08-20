package com.ing.modelbank.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionDTO implements Serializable{
	

	private static final long serialVersionUID = 1L;
	
	private int fromAccount;
	private int toAccount;
	private double amount;

}
