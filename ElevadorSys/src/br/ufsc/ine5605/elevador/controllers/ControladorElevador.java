package br.ufsc.ine5605.elevador.controllers;

import br.ufsc.ine5605.elevador.interfaces.IControladorElevador;
import br.ufsc.ine5605.elevador.interfaces.IElevador;
import br.ufsc.ine5605.elevador.objects.Elevador;

public class ControladorElevador implements IControladorElevador {

	private Elevador elevador;

	public ControladorElevador() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public IElevador inicializarElevador(int andarAtual, int totalAndaresPredio, int capacidade, int totalPessoas) {
		return elevador = new Elevador(andarAtual, totalAndaresPredio, capacidade, totalPessoas);
	}

	@Override
	public String subir() {
		elevador.subir();
		return "Andar subiu com sucesso \nAndar atual: " + elevador.getAndarAtual();
	}

	@Override
	public String descer() {
		elevador.descer();
		return "Andar desceu com sucesso \nAndar atual: " + elevador.getAndarAtual();
	}

	@Override
	public String entraPessoa() {
		if (elevador.getTotalPessoas() < elevador.getCapacidade()) {
			elevador.entraPessoa();
			return "Pessoa entrou com sucesso \nPessoas no elevador: " + elevador.getTotalPessoas();
		} else {
			return "Elevador esta no limite maximo de passageiros";
		}
	}

	@Override
	public String saiPessoa() {
		if (elevador.getTotalPessoas() > 0) {
			elevador.saiPessoa();
			return "Pessoa saiu com sucesso \nPessoas no elevador: " + elevador.getTotalPessoas();
		} else {
			return "O elevador esta vazio";
		}

	}

	@Override
	public Elevador getElevador() {
		return elevador;
	}

}
