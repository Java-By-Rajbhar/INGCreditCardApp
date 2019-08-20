package com.ing.modelbank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Payee implements Serializable{

	private static final long serialVersionUID = 28803814348600742L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long payeeId;
	private String payeeName;
	private Integer accountNumber ;
	private String emailId;
	private String IFSC;
	private String status;
	@ManyToOne
	@JoinColumn(name = "accountId", referencedColumnName = "accountId")
	private Account account;


	
}
