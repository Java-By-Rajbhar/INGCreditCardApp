package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ing.modelbank.entity.Merchant;

@Repository
public interface MerchantRepository extends JpaRepository<Merchant, Integer>{

}
