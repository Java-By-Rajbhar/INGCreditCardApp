package com.ing.modelbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.ing.modelbank.entity.PayeeOtp;

public interface PayeeOtpRepository extends JpaRepository<PayeeOtp, Integer> {

	PayeeOtp findByOtpAndPayeeId(Long otp, Long payeeId);

}
