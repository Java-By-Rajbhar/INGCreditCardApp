package com.ing.modelbank.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class CardSummary implements Serializable{
	
	private static final long serialVersionUID = 28803814348600742L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private String merchantName;
	private Double amount;
	private Date transactionDate ;
	private String transactionType;
	@ManyToOne
	private Customer customer;



}
