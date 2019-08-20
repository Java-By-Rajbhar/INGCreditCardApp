package com.ing.modelbank.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class CustomerDetailsDto implements Serializable{

	private static final long serialVersionUID = -8610320364370157270L;

	private String loginId;
	private Integer accountNumber;
	private String message;
}
