package com.ing.modelbank.service;

import com.ing.modelbank.dto.CustomerDetailsDto;
import com.ing.modelbank.dto.CustomerDto;

public interface ICustomerService {

	public CustomerDetailsDto register(CustomerDto customerDto);
}
