package com.ing.modelbank.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Merchant implements Serializable {

	private static final long serialVersionUID = 28803814348600742L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Integer merchandtId;
	private String merchantString;
	private String product;
	private double price;
}
