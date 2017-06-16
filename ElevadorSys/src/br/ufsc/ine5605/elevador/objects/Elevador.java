package br.ufsc.ine5605.elevador.objects;

import br.ufsc.ine5605.elevador.interfaces.IElevador;

public class Elevador implements IElevador {

	private int capacidade;
	private int totalPessoas;
	private int totalAndaresPredio;
	private int andarAtual;

	// Constructor

	public Elevador(int andarAtual, int totalAndaresPredio, int capacidade, int totalPessoas) {
		this.capacidade = capacidade;
		this.totalPessoas = totalPessoas;
		this.totalAndaresPredio = totalAndaresPredio;
		this.andarAtual = andarAtual;
	}

	// Getters & Setters

	@Override
	public int getCapacidade() {
		return this.capacidade;
	}

	@Override
	public int getTotalPessoas() {
		return this.totalPessoas;
	}

	@Override
	public void setTotalAndaresPredio(int totalAndaresPredio) {
		this.totalAndaresPredio = totalAndaresPredio;
	}

	@Override
	public int getTotalAndaresPredio() {
		return this.totalAndaresPredio;
	}

	@Override
	public int getAndarAtual() {
		return this.andarAtual;
	}

	// Functions

	@Override
	public String entraPessoa() {
		this.totalPessoas++;
		return "Elevador entrando uma pessoa";
	}

	@Override
	public String saiPessoa() {
		this.totalPessoas--;
		return "Elevador saindo uma pessoa";
	}

	@Override
	public String subir() {
		this.andarAtual++;
		return "Elevador subindo";
	}

	@Override
	public String descer() {
		this.andarAtual--;
		return "Elevador descendo";
	}

}
