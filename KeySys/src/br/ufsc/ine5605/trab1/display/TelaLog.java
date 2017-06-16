package br.ufsc.ine5605.trab1.display;

import java.util.InputMismatchException;
import br.ufsc.ine5605.trab1.controllers.ControladorLog;
import br.ufsc.ine5605.trab1.interfaces.DisplayEx;

public class TelaLog implements DisplayEx {

	// Constructor
	
	public TelaLog(ControladorLog ctrlLog) {
		super();
	}
	
	// Override methods

	@Override
	public void exibeMenuPrincipal() {
		System.out.println("-------------SisRegistro-------------");
		System.out.println("\n1) Exibe todos Registros");
		System.out.println("2) Busca Registros por motivo");
		System.out.println("3) Busca Registros por matricula");
		System.out.println("4) Busca Registros por placa");
		System.out.println("0) Encerra este sistema");
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
				listaLogsGeral();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 2:
				buscaRegByMot();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 3:
				buscaRegByNumMat();
				exibeMenuPrincipal();
				try {
					opcao = teclado.nextInt();
				} catch (InputMismatchException e) {
					System.out.println("\nOpcao digitada incorretamente");
				}
				teclado.nextLine();
				break;
			case 4:
				buscaRegByPlaca();
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

	// Search methods
	
	public void buscaRegByMot() {
		System.out.println("\nDigite o motivo da criacao do registro: \nDigite 0 para sair do metodo: ");

		String motivo = teclado.nextLine();

		if(motivo.equals("0")){
			return;
		}
		
		try {
			System.out.println(
					ControladorLog.getCtrlLog().exibeListaLogs(ControladorLog.getCtrlLog().buscaLogsByMotivo(motivo)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscaRegByNumMat() {
		System.out.println("\nDigite o numero de matricula do funcionario: \nDigite 0 para sair do metodo: ");

		String numeroMatricula = teclado.next();
		teclado.nextLine();
		
		if(numeroMatricula.equals("0")){
			return;
		}

		try {
			System.out.println(ControladorLog.getCtrlLog()
					.exibeListaLogs(ControladorLog.getCtrlLog().buscaLogsByMatricula(numeroMatricula)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void buscaRegByPlaca() {
		System.out.println("\nDigite a placa do veiculo: \nDigite 0 para sair do metodo: ");

		String placa = teclado.next();
		teclado.nextLine();
		
		if(placa.equals("0")){
			return;
		}

		try {
			System.out.println(
					ControladorLog.getCtrlLog().exibeListaLogs(ControladorLog.getCtrlLog().buscaLogsByPlaca(placa)));
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	// List method
	
	public void listaLogsGeral() {
		try {
			System.out.println(ControladorLog.getCtrlLog().exibeListaLogsGeral());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
