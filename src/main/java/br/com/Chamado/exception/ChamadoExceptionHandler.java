package br.com.Chamado.exception;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
