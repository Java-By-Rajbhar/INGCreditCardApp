package com.ing.modelbank.service;

import com.ing.modelbank.dto.LoginDto;
import com.ing.modelbank.dto.LoginResponseDto;

public interface LoginService {

	public LoginResponseDto login(LoginDto loginDto);

}
