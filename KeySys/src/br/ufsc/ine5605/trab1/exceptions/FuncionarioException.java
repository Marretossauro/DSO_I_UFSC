package br.ufsc.ine5605.trab1.exceptions;

public class FuncionarioException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FuncionarioException() {
		this("\nFuncionario inexistente");
	}

	public FuncionarioException(String message) {
		super(message);
	}

}
