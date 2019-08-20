package com.ing.modelbank.service;


import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

import com.ing.modelbank.dto.MerchantDto;
import com.ing.modelbank.dto.MerchantResponseDto;
import com.ing.modelbank.entity.Merchant;
import com.ing.modelbank.repository.MerchantRepository;

@RunWith(SpringRunner.class)
public class MerchantServiceImplTest {

	@InjectMocks
	MerchantServiceImpl merchantServiceImpl;
	
	@Mock
	MerchantRepository merchantRepository;
	
	MerchantDto merchantDto;
	MerchantResponseDto merchantResponseDto;
	
	@Test
	public void getListOfMerchantsTest() {
		
		List<Merchant> l=new ArrayList<>();
		Merchant merchant=new Merchant();
		merchant.setMerchantId(1);
		merchant.setMerchantName("amazon");
		merchant.setPrice(300);
		merchant.setProduct("earphones");
		l.add(merchant);
		when(merchantRepository.findAll()).thenReturn(l);
		List<MerchantDto> merchantList=merchantServiceImpl.getListOfMerchants();
		assertEquals(1, merchantList.size());
		
	}
	@Test
	public void getmerchant() {
		merchantResponseDto=new MerchantResponseDto();
		merchantResponseDto.setMerchantName("amazon");
		Merchant merchant=new Merchant();
		merchant.setMerchantId(1);
		merchant.setMerchantName("amazon");
		merchant.setPrice(300);
		merchant.setProduct("earphones");
		when(merchantRepository.findByMerchantId(1)).thenReturn(merchant);
		MerchantResponseDto merchantById = merchantServiceImpl.getmerchant(merchant.getMerchantId());
	    assertEquals("amazon", merchantById.getMerchantName());
	}
}
