package br.com.vertigo.services.exceptions;

public class BadRequests extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public BadRequests(String msg) {
		super(msg);
	}
	
}
