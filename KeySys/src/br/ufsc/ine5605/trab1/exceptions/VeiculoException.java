package br.ufsc.ine5605.trab1.exceptions;

public class VeiculoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public VeiculoException() {
		this("\nVeiculo indisponivel ou inexistente");
	}

	public VeiculoException(String message) {
		super(message);
	}

}