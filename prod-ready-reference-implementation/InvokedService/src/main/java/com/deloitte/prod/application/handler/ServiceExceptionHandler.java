package com.deloitte.prod.application.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.context.request.WebRequest;

import com.deloitte.prod.application.model.ErrorResponse;

/*
 * This is the error handler to handle all errors and send the customized response.
 */
@ControllerAdvice
public class ServiceExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(ServiceExceptionHandler.class);

	@ExceptionHandler(HttpStatusCodeException.class)
	public ResponseEntity<Object> handleHttpErrors(HttpStatusCodeException e, WebRequest request) {
		logger.error("HttpStatusCodeException: {} " , e);
		ErrorResponse error=prepareError(e,request);
		return new ResponseEntity<Object>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleGenericError(Exception e, WebRequest request) {
		logger.error("Error Occured: {} " , e);
		ErrorResponse error=prepareError(e,request);
		return new ResponseEntity<Object>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<Object> databaseError(DataIntegrityViolationException e, WebRequest request) {
		logger.error("DataIntegrityViolationException: {} " , e);
		ErrorResponse error=prepareError(e,request);
		return new ResponseEntity<Object>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<Object> databaseError(DataAccessException e, WebRequest request) {
		logger.error("DataAccessException: {} " , e);
		ErrorResponse error=prepareError(e,request);
		return new ResponseEntity<Object>(error,  HttpStatus.INTERNAL_SERVER_ERROR);
	}


	private ErrorResponse prepareError(Throwable e, WebRequest request) {
		ErrorResponse error= new ErrorResponse(500,e.getMessage(),request.getContextPath());
		return error;
	}
}
