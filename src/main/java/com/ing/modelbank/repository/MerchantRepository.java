package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.modelbank.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Integer> {

	Merchant findByMerchantId(int merchantId);



}
