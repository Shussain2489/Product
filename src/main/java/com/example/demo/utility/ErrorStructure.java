package com.example.demo.utility;

import org.springframework.http.ResponseEntity;

public class ErrorStructure <T> {
	
	private int statusCode;
	private String errorMessage;
	private T errorData;
	
	public int getStatusCode() {
		return statusCode;
	}
	public ErrorStructure<T> setStatusCode(int statusCode) {
		this.statusCode = statusCode;
		return this;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public ErrorStructure<T> setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
		return this;
	}
	public T getErrorData() {
		return errorData;
	}
	public ErrorStructure<T> setErrorData(T errorData) {
		this.errorData = errorData;
		return this;
	}
	@Override
	public String toString() {
		return "ErrorStructure [statusCode=" + statusCode + ", errorMessage=" + errorMessage + ", errorData="
				+ errorData + "]";
	}
	
	
}
