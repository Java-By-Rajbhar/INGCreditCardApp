package com.ing.modelbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.CardSummary;


@Repository
public interface CardSummarRepository extends JpaRepository<CardSummary, Long> {


	@Query("select t from CardSummary t where t.customer.customerId=:customerId")
	List<CardSummary> findCardDetail(@Param(value = "customerId") Long customerId);
	
}
