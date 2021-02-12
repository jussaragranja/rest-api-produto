package br.com.jussara.apirest.produto.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
public class ResourceInternalErrorException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public ResourceInternalErrorException(String message) {
		super(message);
	}
}