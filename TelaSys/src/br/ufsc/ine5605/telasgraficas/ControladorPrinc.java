package br.ufsc.ine5605.telasgraficas;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControladorPrinc implements ActionListener {

	private TelaPrincipal telaPrincipal;

	public ControladorPrinc() {

		telaPrincipal = new TelaPrincipal(this);

	}

	public void inicia() {
		telaPrincipal.setVisible(true);
	}

	public void incluiFuncionario(String nome, String telefone) {

		// Instancia o funcionario

		System.out.println("Nome: " + nome);

		// Inclui na lista

		System.out.println("Telefone: " + telefone);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		incluiFuncionario(telaPrincipal.getTfNomeText(), telaPrincipal.getTfFoneText());
	}

}
