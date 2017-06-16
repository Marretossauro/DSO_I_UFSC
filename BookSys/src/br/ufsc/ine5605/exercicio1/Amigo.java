package br.ufsc.ine5605.exercicio1;

import java.util.ArrayList;

public class Amigo {
	private int codigo;
	private String nome;
	private int numTelefone;
	private String email;
	private ArrayList<GeneroLivro> generoLivrosGosta;

	/*
	 * ======Construtor============
	 */
	public Amigo(int codigo, String nome, int numTelefone, String email) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.numTelefone = numTelefone;
		this.email = email;
		this.generoLivrosGosta = new ArrayList<>();
	}
	/*
	 * ============================
	 */
	// Getters / Setters

	public String getNome() {
		return nome;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumTelefone() {
		return numTelefone;
	}

	public void setNumTelefone(int numTelefone) {
		this.numTelefone = numTelefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void addGenero(GeneroLivro generoLivro) {
		if (!generoLivrosGosta.contains(generoLivro)) {
			generoLivrosGosta.add(generoLivro);
		}
		if (!generoLivro.contemAmigo(this)) {
			generoLivro.addAmigo(this);
		}

	}

	/*
	 * ======Fim getters and setters=============
	 */

}