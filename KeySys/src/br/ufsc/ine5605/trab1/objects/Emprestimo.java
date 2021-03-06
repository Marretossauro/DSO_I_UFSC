package br.ufsc.ine5605.trab1.objects;

import java.io.Serializable;

public class Emprestimo implements Serializable{

	private static final long serialVersionUID = 4775297518394110487L;
	private int codigo;
	private Funcionario usuario;
	private Veiculo utilitario;

	// Constructor
	
	public Emprestimo(Funcionario usuario, Veiculo utilitario) {
		super();
		this.usuario = usuario;
		this.utilitario = utilitario;
	}
	
	// Getters & Setters

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Funcionario getUsuario() {
		return usuario;
	}

	public void setUsuario(Funcionario funcionario) {
		this.usuario = funcionario;
	}

	public Veiculo getUtilitario() {
		return utilitario;
	}

	public void setUtilitario(Veiculo utilitario) {
		this.utilitario = utilitario;
	}

}