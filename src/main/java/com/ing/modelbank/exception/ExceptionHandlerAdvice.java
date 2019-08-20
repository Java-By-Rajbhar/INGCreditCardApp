package com.ing.modelbank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ing.modelbank.exception.ErrorReponse;


@ControllerAdvice
public class ExceptionHandlerAdvice extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	private ResponseEntity<ErrorReponse> handleAllExceptions(Exception ex) {
		ErrorReponse errorResponse = new ErrorReponse(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(PasswordMissMatchException.class)
	private ResponseEntity<ErrorReponse> handleExceptions(PasswordMissMatchException ex) {
		ErrorReponse errorResponse = new ErrorReponse(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(value = { AccountNotFoundException.class })
	public ResponseEntity<ResponseError> ageException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}
	
	@ExceptionHandler(PayeeDoesNotExistsException.class)
	public ResponseEntity<ResponseError> payeeExceptionHandler(PayeeDoesNotExistsException ex)
	{
		ResponseError error =  new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(PayeeNotFoundException.class)
	public ResponseEntity<ResponseError> payeeExceptionHandler1(PayeeNotFoundException ex)
	{
		ResponseError error =  new ResponseError(ex.getMessage(), HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseError>(error, HttpStatus.NOT_FOUND);
	}
	
}