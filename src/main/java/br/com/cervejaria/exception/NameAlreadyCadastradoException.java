package br.com.cervejaria.exception;

public class NameAlreadyCadastradoException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public NameAlreadyCadastradoException(String mensagem) {
		super(mensagem);
	}
}
