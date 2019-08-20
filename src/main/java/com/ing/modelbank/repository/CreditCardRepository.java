package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.modelbank.entity.CreditCard;

public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
