package br.com.vertigo.services.exceptions;

public class ExceptionId extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public ExceptionId(String msg) {
		super(msg);
	}
}
