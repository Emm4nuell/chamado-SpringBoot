package br.com.Chamado.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.hibernate.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ChamadoExceptionHandler {
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<StandarError> nullPointerException(NullPointerException exception, HttpServletRequest request){
		StandarError error = new StandarError(LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Object not found", 
				exception.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<StandarError> methodArgumentNotValidException(MethodArgumentNotValidException exception, HttpServletRequest request){
		ValidationError error = new ValidationError(
				LocalDateTime.now(), 
				HttpStatus.BAD_REQUEST.value(), 
				"Validation error", 
				"Erro da validação dos campos", 
				request.getRequestURI());
		
		for (FieldError x : exception.getBindingResult().getFieldErrors()) {
			error.addError(x.getField(), x.getDefaultMessage());
		}
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandarError> objectNotFoundException(ObjectNotFoundException exception, HttpServletRequest request){
		StandarError error = new StandarError(
				LocalDateTime.now(), 
				HttpStatus.NOT_FOUND.value(), 
				"Identifiesr exists", 
				exception.getMessage(), 
				request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

}
