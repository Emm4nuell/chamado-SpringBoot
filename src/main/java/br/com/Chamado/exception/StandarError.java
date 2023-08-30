package br.com.Chamado.exception;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StandarError {
	
	private LocalDateTime timestamp = LocalDateTime.now();
	private Integer status;
	private String error;
	private String message;
	private String path;

}
