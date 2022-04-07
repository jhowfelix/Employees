package br.com.vertigo.controllers.exceptions;

import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import br.com.vertigo.services.exceptions.ErroInternoException;
import br.com.vertigo.services.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(JsonParseException.class)
	public ResponseEntity<StandardError> badRequest(JsonParseException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ErroInternoException.class)
	public ResponseEntity<StandardError> interErro(ErroInternoException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				request.getRequestURI());

		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(NumberFormatException.class)
	public ResponseEntity<StandardError> ErrorId(NumberFormatException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<StandardError> ErrorData(InvalidFormatException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<StandardError> validationForm(ConstraintViolationException e, HttpServletRequest request) {
		HttpStatus status = HttpStatus.BAD_REQUEST;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), e.getMessage().toString(),
				request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}