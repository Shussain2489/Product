package com.example.demo.utility;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class AppExceptionHandler extends ResponseEntityExceptionHandler {

		private ErrorStructure structure;

		public AppExceptionHandler(ErrorStructure structure) {
			super();
			this.structure = structure;
		}
		
 	
		@SuppressWarnings("unchecked")
		@Override
		protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			org.springframework.http.HttpHeaders headers, HttpStatusCode status, WebRequest request) {
			
			List<ObjectError> errors = ex.getAllErrors();
			
			Map<String, String> messages = new HashMap<String, String>();
			
			errors.forEach(error -> {
				String message = error.getDefaultMessage();
				FieldError fieldError = (FieldError) error;
				String field = fieldError.getField();
				messages.put(field, message);
			});
			
		return ResponseEntity.badRequest().body(
				structure.setStatusCode(HttpStatus.BAD_REQUEST.value())
				.setErrorMessage("Invalid inputs")
				.setErrorData(messages));
		
		}
}
