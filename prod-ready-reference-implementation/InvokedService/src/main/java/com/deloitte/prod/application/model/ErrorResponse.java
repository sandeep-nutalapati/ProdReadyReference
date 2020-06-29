package com.deloitte.prod.application.model;

/**
 * This is the Error response class, if any error occurs then the response structure across 
 * the micro services need be aligned and the response needs to be propogated. 
 * This is the sample structure of common error. 
 * Basically this class will be used in Controller advice which captures the exception and 
 * converts to this format and propogates further. 
 *
 */
public class ErrorResponse {

	private int errorCode;
	private String message;
	private String detail;

	 
	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
	}

	public ErrorResponse(int status, String message,String detail) {
		super();
		this.errorCode = status;
		this.message = message;
		this.detail=detail;
	}

	public int getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "ErrorResponse [status=" + errorCode + ", message=" + message + "]";
	}
}
