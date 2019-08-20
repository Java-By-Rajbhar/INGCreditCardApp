package com.ing.modelbank.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Transaction implements Serializable {

	private static final long serialVersionUID = 777193507939333999L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long transactionId;
	private int fromAccount;
	private int toAccount;
	private double amount;
	private LocalDate transactionDate;
	private String transactionType;
	@ManyToOne
	private Account account;

}
