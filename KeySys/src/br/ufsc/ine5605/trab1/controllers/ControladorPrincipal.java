package br.ufsc.ine5605.trab1.controllers;

import br.ufsc.ine5605.trab1.display.TelaPrincipalGeral;

public class ControladorPrincipal extends Controlador {

	private TelaPrincipalGeral telaPrincGer;
	private static ControladorPrincipal ctrlPrincipal;

	// Constructor

	public ControladorPrincipal() {
		super();
		telaPrincGer = new TelaPrincipalGeral(this);
	}

	// Override method

	@Override
	public void inicia() {
		// telaPrincipal.exibeMenuInicial();
		telaPrincGer.setVisible(true);
	}

	// Getters & Setters

	public static ControladorPrincipal getCtrlPrincipal() {
		if (ctrlPrincipal == null) {
			ctrlPrincipal = new ControladorPrincipal();
		}
		return ctrlPrincipal;
	}

	public static void setCtrlPrincipal(ControladorPrincipal ctrlPrincipal) {
		ControladorPrincipal.ctrlPrincipal = ctrlPrincipal;
	}

	public ControladorEmprestimo getCtrlEmprestimo() {
		return ControladorEmprestimo.getCtrlEmprestimo();
	}

	public ControladorFuncionario getCtrlFuncionario() {
		return ControladorFuncionario.getCtrlFuncionario();
	}

	public ControladorLog getCtrlLog() {
		return ControladorLog.getCtrlLog();
	}

	public ControladorVeiculo getCtrlVeiculo() {
		return ControladorVeiculo.getCtrlVeiculo();
	}

}
