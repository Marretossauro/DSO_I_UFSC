package br.ufsc.ine5605.trab1.exceptions;

public class ListaVaziaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ListaVaziaException() {
		this("\nLista Vazia");
	}
	
	public ListaVaziaException(String message) {
		super(message);
	}

}
