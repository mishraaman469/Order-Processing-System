package com.mt.inventory.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.mt.inventory.entity.Orders;
import com.mt.inventory.exception.entity.ApiError;

@RestControllerAdvice
public class StockExceptionHandler {
	
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<ApiError> stockNotFoundException(StockNotFoundException stockNotFoundException){
		ApiError error=new ApiError(404,stockNotFoundException.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(QuantityException.class)
	public ResponseEntity<ApiError> quantityException(QuantityException quantityException){
		ApiError error=new ApiError(404,quantityException.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiError> globalException(Exception exception){
		ApiError error=new ApiError(404,exception.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler(NullCheckException.class)
	public ResponseEntity<ApiError> NullCheckExceptionHandler(NullCheckException nullCheckException){
		ApiError error =new ApiError(404,nullCheckException.getMessage(),new Date());
		return new ResponseEntity<ApiError>(error,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
