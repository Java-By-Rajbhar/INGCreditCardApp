package com.ing.modelbank.service;

import com.ing.modelbank.dto.PayeeOtpRequestDto;
import com.ing.modelbank.dto.PayeeOtpResponseDTO;
import com.ing.modelbank.dto.PayeeRequestDTO;
import com.ing.modelbank.dto.PayeeResponseDTO;

public interface PayeeService {




	PayeeOtpResponseDTO validateOtp(PayeeOtpRequestDto payeeOtpRequestDto, Long payeeId);


	PayeeResponseDTO addPayee(PayeeRequestDTO payeeRequestDTO, long customerId);

}
