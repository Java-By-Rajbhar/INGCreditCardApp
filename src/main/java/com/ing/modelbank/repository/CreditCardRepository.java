package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.CreditCard;

@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

	@Query("select t from CreditCard t where t.customer.customerId=:customerId")
	CreditCard findCustomerCardDetail(@Param(value = "customerId") Long customerId);

	public CreditCard findByCustomerCustomerId(long customerId);

	CreditCard findByCreditCardId(Long creditCardId);

}
