package br.ufsc.ine5605.trab1.objects;

import java.io.Serializable;

public class Pessoa implements Serializable {

	private static final long serialVersionUID = 5657332521282369784L;
	private String nome;
	private String dataNascimento;
	private String telefone;

	// Constructors

	public Pessoa(String nome, String dataNascimento, String telefone) {
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.telefone = telefone;
	}

	// Getters & Setters

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

}
