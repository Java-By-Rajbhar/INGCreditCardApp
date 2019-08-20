package com.ing.modelbank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Payee;

@Repository
public interface PayeeRepository extends JpaRepository<Payee, Long> {

	@Query("select t from Payee t where t.account.accountId=:accountId")
	List<Payee> findByUserAccountId(@Param(value = "accountId") Long accountId);

	Payee findByPayeeId(Long payeeId);

	public Payee findByAccountNumber(Integer accountNumber);

}
