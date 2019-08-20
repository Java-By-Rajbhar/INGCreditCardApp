package com.ing.modelbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ing.modelbank.entity.CardSummary;
import com.ing.modelbank.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	

	@Query("select t from CreditCard t where t.customer.customerId=:customerId")
	CreditCard findCustomerCardDetail(@Param(value = "customerId") Long customerId);
	
}
