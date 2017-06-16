package br.ufsc.ine5605.trab1.controllers;

import br.ufsc.ine5605.trab1.display.TelaAddVeicFunc;
import br.ufsc.ine5605.trab1.display.TelaExcluirVeic;
import br.ufsc.ine5605.trab1.display.TelaPrincipal;
import br.ufsc.ine5605.trab1.display.TelaPrincipalGeral;

public class ControladorPrincipal extends Controlador {

	private TelaPrincipal telaPrincipal;
	private TelaPrincipalGeral telaPrincGer;
	private TelaAddVeicFunc telaAddVeicFunc;
	private TelaExcluirVeic telaExcluiVeic;
	private static ControladorPrincipal ctrlPrincipal;

	// Constructor

	public ControladorPrincipal() {
		super();
		telaPrincipal = new TelaPrincipal(this);
		telaPrincGer = new TelaPrincipalGeral(this);
		telaAddVeicFunc = new TelaAddVeicFunc(this);
		telaExcluiVeic = new TelaExcluirVeic(this);
	}

	// Override method

	@Override
	public void inicia() {
		// telaPrincipal.exibeMenuInicial();
		telaPrincGer.setVisible(true);
	}

	// Window method

	public void telaAddVeicFunc() {
		telaAddVeicFunc.setVisible(true);
	}
	
	public void telaExcluiVeic() {
		telaExcluiVeic.setVisible(true);
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
