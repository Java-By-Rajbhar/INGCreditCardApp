package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ing.modelbank.entity.Otp;

public interface OtpRepository extends JpaRepository<Otp, Integer> {

	Otp findByOtpAndReferenceId(Long otp, Long referenceId);
	
}
