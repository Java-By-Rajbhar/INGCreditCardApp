package com.ing.modelbank.service;

import com.ing.modelbank.dto.MerchantResponseDto;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ing.modelbank.dto.MerchantDto;



public interface MerchantService {
	
	
	ResponseEntity<List<MerchantDto>> getListOfMerchants();

	MerchantResponseDto getmerchant(int merchantId);

}
