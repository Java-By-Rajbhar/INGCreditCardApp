package com.ing.modelbank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCard implements Serializable{

	private static final long serialVersionUID = 28803814348600742L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="my_entity_seq_gen")
	@SequenceGenerator(name="my_entity_seq_gen", sequenceName="MY_ENTITY_SEQ")
	private Long creditCardId;
	private Long cardCardNumber;
	private String creditCardHolderName;
	private String creditCardType;
	private String expiryDate;
	private int cvv;
	private double creditLimit;
	
	@OneToOne
	private Customer customer;
	
}
