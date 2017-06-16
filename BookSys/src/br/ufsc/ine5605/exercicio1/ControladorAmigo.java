package br.ufsc.ine5605.exercicio1;

import java.util.ArrayList;

public class ControladorAmigo {
	private ArrayList<Amigo> listaAmigos;
	private TelaAmigo telaAmigo;

	public ControladorAmigo() {
		telaAmigo = new TelaAmigo(this);
		listaAmigos = new ArrayList<>();

	}

	public void inicia() {
		telaAmigo.exibeMenuInicial();
	}

	public void incluiAmigo(Amigo amigo) {
		listaAmigos.add(amigo);
		exibeListaAmigos(listaAmigos);

	}

	public boolean alteraAmigoPeloCodigo(int codigo, Amigo amigo) {

		boolean consegueAlterar = false;
		for (Amigo amigoAlterar : listaAmigos) {
			if (amigoAlterar.getCodigo() == codigo) {
				listaAmigos.set(codigo - 1, amigo);
				consegueAlterar = true;
				break;
			}
		}
		return consegueAlterar;
	}

	public ArrayList<Amigo> listarAmigos() {
		return listaAmigos;
	}

	public boolean excluiAmigoPeloCodigo(int codigo) {

		boolean consegueExcluir = false;
		for (Amigo amigoExcluir : listaAmigos) {
			if (amigoExcluir.getCodigo() == codigo) {
				listaAmigos.remove(amigoExcluir);
				consegueExcluir = true;
				break;
			}
		}
		return consegueExcluir;
	}

	public String exibeListaAmigos(ArrayList<Amigo> listaAmigos) {
		if (!listaAmigos.isEmpty()) {
			for (Amigo amigo : listaAmigos) {
				return ("\nCodigo: " + amigo.getCodigo() + "\nNome: " + amigo.getNome() + "\nNumero de telefone: "
						+ amigo.getNumTelefone() + "\nEmail: " + amigo.getEmail());
			}
		}
		return "Lista Vazia";
	}
}