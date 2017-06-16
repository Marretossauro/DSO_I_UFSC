package br.ufsc.ine5605.trab1.exceptions;

public class AcessoBloqueadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public AcessoBloqueadoException() {
		this("\nAcesso Bloqueado");
	}

	public AcessoBloqueadoException(String message) {
		super(message);
	}

}
