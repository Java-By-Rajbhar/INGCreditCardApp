package com.ing.modelbank.service;

import com.ing.modelbank.dto.ResponseAccountDto;

public interface AccountService {

	ResponseAccountDto getAccountSummary(Integer accountNumber);

}
