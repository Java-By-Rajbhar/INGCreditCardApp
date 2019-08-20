package com.ing.modelbank.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ing.modelbank.dto.MerchantDto;


public interface MerchantService {
	
	
	ResponseEntity<List<MerchantDto>> getListOfMerchants();

}
