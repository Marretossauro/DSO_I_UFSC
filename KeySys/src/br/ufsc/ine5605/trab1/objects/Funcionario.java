package br.ufsc.ine5605.trab1.objects;

import java.util.ArrayList;
import java.io.Serializable;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;

public class Funcionario extends Pessoa implements Serializable {

	private static final long serialVersionUID = -6014649005133531248L;
	private String numeroMatricula;
	private TipoCargo cargo;
	private ArrayList<Veiculo> listaDeCarrosLiberados;
	private int tentativas;
	private boolean bloqueado;

	// Constructors

	public Funcionario(String numeroMatricula, String nome, String dataNascimento, String telefone) {
		super(nome, dataNascimento, telefone);
		this.numeroMatricula = numeroMatricula;
		this.listaDeCarrosLiberados = new ArrayList<>();
		this.tentativas = 0;
		this.bloqueado = false;
	}

	// Getters & Setters

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public TipoCargo getCargo() {
		return cargo;
	}

	public void setCargo(TipoCargo cargo) {
		this.cargo = cargo;
	}

	public ArrayList<Veiculo> getListaDeCarrosLiberados() {
		return listaDeCarrosLiberados;
	}

	public int getTentativas() {
		return tentativas;
	}

	public void setTentativas(int tentativas) {
		this.tentativas = tentativas;
	}

	// Add & Delete methods

	public boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public void addTentativa() {
		this.tentativas++;
	}

}
