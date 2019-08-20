package com.ing.modelbank.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ing.modelbank.controller.MerchantController;
import com.ing.modelbank.dto.MerchantDto;
import com.ing.modelbank.entity.Merchant;
import com.ing.modelbank.repository.MerchantRepository;

@Service
public class MerchantServiceImpl implements MerchantService {

	@Autowired
	MerchantRepository merchantRepository;
	public static final Logger logger = LoggerFactory.getLogger(MerchantController.class);

	@Override

	public ResponseEntity<List<MerchantDto>> getListOfMerchants() {

		logger.info("inside getListOfMerchants method of merchant Service class");

		List<MerchantDto> merchant = new ArrayList<>();
		List<Merchant> merchantlist = merchantRepository.findAll();
		for (Merchant merchant2 : merchantlist) {
			MerchantDto merchantDto = new MerchantDto();
			merchantDto.setMerchandtId(merchant2.getMerchantId());
			merchantDto.setMerchantName(merchant2.getMerchantName());
			merchantDto.setPrice(merchant2.getPrice());
			merchantDto.setProduct(merchant2.getProduct());

			merchant.add(merchantDto);
		}

		return new ResponseEntity<List<MerchantDto>>(merchant, HttpStatus.OK);
	}

}
