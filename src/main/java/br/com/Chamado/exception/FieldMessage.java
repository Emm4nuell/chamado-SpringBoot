package br.com.Chamado.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FieldMessage {

	private String field;
	private String message;
}
