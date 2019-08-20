package com.ing.modelbank.controller;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ing.modelbank.dto.DeleteResponseDto;
import com.ing.modelbank.dto.PayeeOtpRequestDto;
import com.ing.modelbank.dto.PayeeOtpResponseDTO;
import com.ing.modelbank.dto.PayeeRequestDTO;
import com.ing.modelbank.dto.PayeeResponseDTO;
import com.ing.modelbank.dto.PayeeUpdateRequestDto;
import com.ing.modelbank.dto.PayeeUpdateResponseDto;
import com.ing.modelbank.dto.ResponsePayeeDto;
import com.ing.modelbank.service.DeletePayeeService;
import com.ing.modelbank.service.PayeeService;
import com.ing.modelbank.service.PayeeUpdateServiceImpl;
import com.ing.modelbank.service.PayeesListService;

@RestController
@RequestMapping("/api")
@CrossOrigin(allowedHeaders = {"*","/"},origins ={"*","/"})
public class PayeeController {
	
	
	@Autowired
	PayeeUpdateServiceImpl payeeUpdateServiceImpl;
	@Autowired
	PayeesListService payeesListService;
	
	@Autowired
	PayeeService payeeService;
	
	public static final Logger logger  = LoggerFactory.getLogger(PayeeController.class);

    @Autowired	
	private DeletePayeeService deletePayeeService;
    
    
	
	@DeleteMapping("/deletePayee/{payeeId}")
	public ResponseEntity<DeleteResponseDto> deletePayee(@PathVariable Long payeeId)
	{
		logger.info("in PayeeController");
		
		DeleteResponseDto deleteResponseDto=deletePayeeService.deletePayee(payeeId);
		
		return new ResponseEntity<>(deleteResponseDto,HttpStatus.OK);
	}

	
	@GetMapping("/ListOfPayees/{accountId}")
	
	public ResponseEntity<List<ResponsePayeeDto>> getListOfPayees(@PathVariable("accountId") Long accountId) {
		
		logger.info("inside payeeController... ");
      
		List<ResponsePayeeDto> payeeList=payeesListService.getListOfPayees(accountId);
		
		return new ResponseEntity<List<ResponsePayeeDto>>(payeeList, HttpStatus.OK);
	}
	
	@PutMapping("/updatePayee")
	public ResponseEntity<PayeeUpdateResponseDto> updatePayee(@RequestBody PayeeUpdateRequestDto payeeUpdateRequestDto)
	{
		logger.info("inside updatePayee method of PayeeController");
		logger.info("PayeeUpdateRequestDto data={}",payeeUpdateRequestDto);
		PayeeUpdateResponseDto responseDto = payeeUpdateServiceImpl.updatePayee(payeeUpdateRequestDto);
		return new ResponseEntity<PayeeUpdateResponseDto>(responseDto, HttpStatus.OK);
	}
	

	@PostMapping("/addPayee/{customerId}")
	public ResponseEntity<PayeeResponseDTO> addPayee(@RequestBody PayeeRequestDTO payeeRequestDTO ,@PathVariable long customerId){
		logger.debug("PayeeController of ");
		PayeeResponseDTO payeeResponseDTO = payeeService.addPayee(payeeRequestDTO,customerId);
		return new ResponseEntity<>(payeeResponseDTO,HttpStatus.CREATED);
	}

	@PostMapping("/validateOtp/{payeeId}")
	public ResponseEntity<PayeeOtpResponseDTO> validateOtp(@RequestBody PayeeOtpRequestDto PayeeOtpRequestDto,@PathVariable Long payeeId){
		logger.debug("PayeeController of ");
		PayeeOtpResponseDTO payeeOtpResponseDTO = payeeService.validateOtp(PayeeOtpRequestDto,payeeId);
		return new ResponseEntity<>(payeeOtpResponseDTO,HttpStatus.CREATED);
	}
}
