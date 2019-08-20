package com.ing.modelbank.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ing.modelbank.dto.MerchantResponseDto;
import com.ing.modelbank.entity.Merchant;
import com.ing.modelbank.repository.MerchantRepository;

@Service
@Transactional
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantRepository merchantRepository;

	public MerchantResponseDto getmerchant(int merchantId) {
		MerchantResponseDto merchantResponseDto=new MerchantResponseDto();
		Merchant merchant	=merchantRepository.findByMerchantId(merchantId);
			BeanUtils.copyProperties(merchant, merchantResponseDto);
			return merchantResponseDto;
	}
	
	

}
