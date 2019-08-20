package com.ing.modelbank.service;

import com.ing.modelbank.dto.MerchantResponseDto;

import java.util.List;



import com.ing.modelbank.dto.MerchantDto;



public interface MerchantService {
	
	
	List<MerchantDto> getListOfMerchants();

	MerchantResponseDto getmerchant(int merchantId);

}
