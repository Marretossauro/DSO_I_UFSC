package br.ufsc.ine5605.trab1.display;

import java.util.InputMismatchException;
import br.ufsc.ine5605.trab1.controllers.Controlador;
import br.ufsc.ine5605.trab1.controllers.ControladorEmprestimo;
import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.controllers.ControladorLog;
import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;
import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;
import br.ufsc.ine5605.trab1.interfaces.DisplayEx;

public class TelaPrincipal implements DisplayEx {

	private Controlador ctrl;

	// Constructor

	public TelaPrincipal(ControladorPrincipal ctrlPrincipal) {
		super();
	}

	// Override methods

	@Override
	public void exibeMenuPrincipal() {
		System.out.println("-------------SisGeral-------------");
		System.out.println("\n1) Sistema de Funcionarios");
		System.out.println("2) Sistema de Veiculos");
		System.out.println("3) Sistema de Emprestimo");
		System.out.println("4) Sistema de Registro");
		System.out.println("0) Encerra o programa");
		System.out.println("\nEscolha a opcao: ");
	}

	@Override
	public void exibeMenuInicial() {

		int opcao = 0;

		exibeMenuPrincipal();

		try {
			opcao = teclado.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("\nOpcao digitada incorretamente");
		}
		teclado.nextLine();

		while (opcao > 0 && opcao < 5 && opcao != 0) {
			switch (opcao) {
			case 1:
				ctrl = ControladorFuncionario.getCtrlFuncionario();
				ctrl.inicia();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 2:
				ctrl = ControladorVeiculo.getCtrlVeiculo();
				ctrl.inicia();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 3:
				ctrl = ControladorEmprestimo.getCtrlEmprestimo();
				ctrl.inicia();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 4:
				ctrl = ControladorLog.getCtrlLog();
				ctrl.inicia();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;

			}
		}
	}

}
