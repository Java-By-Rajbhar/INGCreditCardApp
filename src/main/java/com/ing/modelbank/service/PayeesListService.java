package com.ing.modelbank.service;

import java.util.List;

import com.ing.modelbank.dto.ResponsePayeeDto;

public interface PayeesListService {

	public List<ResponsePayeeDto> getListOfPayees(Long accountId);

}
