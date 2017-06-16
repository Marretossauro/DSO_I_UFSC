package br.ufsc.ine5605.trab1.objects;

import java.io.Serializable;

public class Veiculo implements Serializable {

	private static final long serialVersionUID = 2221649151738514741L;
	private String placa;
	private String modelo;
	private String marca;
	private int ano;
	private int quilometragemAtual;
	private boolean disponibilidade;

	// Constructor
	
	public Veiculo(String placa, String modelo, String marca, int ano, int quilometragemAtual) {
		super();
		this.placa = placa;
		this.modelo = modelo;
		this.marca = marca;
		this.ano = ano;
		this.quilometragemAtual = quilometragemAtual;
		this.disponibilidade = true;
	}
	
	// Getters & Setters

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getQuilometragemAtual() {
		return quilometragemAtual;
	}

	public void setQuilometragemAtual(int quilometragemAtual) {
		this.quilometragemAtual = quilometragemAtual;
	}

	public void setDisponibilidade(boolean disponibilidade) {
		this.disponibilidade = disponibilidade;
	}
	
	// Verifications
	
	public boolean isDisponivel() {
		return disponibilidade;
	}

}
