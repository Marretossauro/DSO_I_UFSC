//package br.ufsc.ine5605.trab1.display;
//
//import java.util.InputMismatchException;
//import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;
//import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;
//import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
//import br.ufsc.ine5605.trab1.exceptions.VeiculoException;
//import br.ufsc.ine5605.trab1.interfaces.DisplayEx;
//
//public class TelaVeiculo implements DisplayEx {
//
//	// Constructor
//
//	public TelaVeiculo(ControladorVeiculo ctrlVeiculo) {
//		super();
//	}
//
//	// Override methods
//
//	@Override
//	public void exibeMenuPrincipal() {
//		System.out.println("-------------SisVeiculo-------------");
//		System.out.println("\n1) Cadastra Veiculo");
//		System.out.println("2) Exclui Veiculo");
//		System.out.println("3) Altera Veiculo");
//		System.out.println("4) Lista Veiculos");
//		System.out.println("0) Encerra este sistema");
//		System.out.println("\nEscolha a opcao: ");
//	}
//
//	@Override
//	public void exibeMenuInicial() {
//
//		int opcao = 0;
//
//		exibeMenuPrincipal();
//
//		try {
//			opcao = teclado.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("\nOpcao digitada incorretamente");
//		}
//		teclado.nextLine();
//
//		while (opcao > 0 && opcao < 5 && opcao != 0) {
//			switch (opcao) {
//			case 1:
//				/*
//				 * CADASTRA VEICULO
//				 */
//				cadastraVeiculo();
//				exibeMenuPrincipal();
//				try {
//					opcao = teclado.nextInt();
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente");
//				}
//				teclado.nextLine();
//				break;
//			case 2:
//				/*
//				 * REMOVER VEICULO
//				 */
//				removerVeiculo();
//				exibeMenuPrincipal();
//				try {
//					opcao = teclado.nextInt();
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente");
//				}
//				teclado.nextLine();
//				break;
//			case 3:
//				/*
//				 * ALTERA VEICULO
//				 */
//				alteraVeiculo();
//				exibeMenuPrincipal();
//				try {
//					opcao = teclado.nextInt();
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente");
//				}
//				teclado.nextLine();
//				break;
//			case 4:
//				/*
//				 * LISTA VEICULO
//				 */
//				listaVeiculos();
//				exibeMenuPrincipal();
//				try {
//					opcao = teclado.nextInt();
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente");
//				}
//				teclado.nextLine();
//				break;
//			}
//		}
//	}
//
//	// Add, remove and Update methods
//
//	private void cadastraVeiculo() {
//
//		System.out.println("\nDigite a placa do veiculo a ser cadastrado (XXX-XXXX): \nDigite 0 para sair do metodo: ");
//		String placa = teclado.nextLine();
//
//		if (placa.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadePlaca(placa)
//				|| ControladorVeiculo.getCtrlVeiculo().verificaVeiculoExiste(placa)) {
//			System.out.println("\nDigite uma placa valida e ainda nao cadastrada: ");
//			placa = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o modelo: \nDigite 0 para sair do metodo: ");
//		String modelo = teclado.nextLine();
//
//		if (modelo.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().verificaModeloEMarca(modelo)) {
//			System.out.println("\nDigite um modelo valido: ");
//			modelo = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite a marca do veiculo: \nDigite 0 para sair do metodo: ");
//		String marca = teclado.nextLine();
//
//		if (marca.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().verificaModeloEMarca(marca)) {
//			System.out.println("\nDigite uma marca valida: ");
//			marca = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o ano no formato YYYY: \nDigite 0 para sair do metodo: ");
//		String anoS = teclado.next();
//		teclado.nextLine();
//
//		if (anoS.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadeAno(anoS)) {
//			System.out.println("\nDigite um ano valido: ");
//			anoS = teclado.next();
//			teclado.nextLine();
//		}
//
//		int ano = Integer.parseInt(anoS);
//
//		System.out.println(
//				"\nDigite a quilometragem atual do carro no momento deste cadastro: \nDigite 0 para sair do metodo: ");
//		String quilometragemAtualS = teclado.next();
//		teclado.nextLine();
//
//		if (quilometragemAtualS.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadeKm(quilometragemAtualS)) {
//			System.out.println("\nDigite uma quilometragem valida:");
//			quilometragemAtualS = teclado.next();
//			teclado.nextLine();
//		}
//
//		int quilometragemAtual = Integer.parseInt(quilometragemAtualS);
//
//		ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().recebeDados(placa, modelo, marca, ano, quilometragemAtual);
//
//		try {
//			ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().adicionaSeDiretoria(placa);
//		} catch (ListaVaziaException e) {
//			System.out.println(e.getMessage());
//		}
//
//		listaVeiculos();
//
//	}
//
//	private void alteraVeiculo() {
//		System.out.println("\nDigite a placa do veiculo a ser alterado (XXX-XXXX): \nDigite 0 para sair do metodo: ");
//		String placa = teclado.nextLine();
//
//		if (placa.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadePlaca(placa)
//				|| !ControladorVeiculo.getCtrlVeiculo().verificaVeiculoExiste(placa)) {
//			System.out.println("\nDigite uma placa existente: ");
//			placa = teclado.nextLine();
//		}
//
//		String placaAtt = "";
//
//		do {
//			System.out.println(
//					"\nDigite uma nova placa para o veiculo a ser alterado (XXX-XXXX): \nDigite 0 para sair do metodo: \nDigite 1 para continuar com a mesma placa: ");
//			placaAtt = teclado.nextLine();
//
//			if (placaAtt.equals("0")) {
//				return;
//			}
//
//			if (placaAtt.equals("1")) {
//				placaAtt = placa;
//				break;
//			}
//
//			if (!ControladorVeiculo.getCtrlVeiculo().validadePlaca(placaAtt)) {
//				System.out.println("\nA placa digitada e invalida\n");
//			}
//
//		} while (!ControladorVeiculo.getCtrlVeiculo().validadePlaca(placaAtt));
//
//		System.out.println("\nDigite o modelo: \nDigite 0 para sair do metodo: ");
//		String modelo = teclado.nextLine();
//
//		if (modelo.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().verificaModeloEMarca(modelo)) {
//			System.out.println("\nDigite um modelo valido: ");
//			modelo = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite a marca do veiculo: \nDigite 0 para sair do metodo: ");
//		String marca = teclado.nextLine();
//
//		if (marca.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().verificaModeloEMarca(marca)) {
//			System.out.println("\nDigite uma marca valida: ");
//			marca = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o ano no formato YYYY: \nDigite 0 para sair do metodo: ");
//		String anoS = teclado.next();
//		teclado.nextLine();
//
//		if (anoS.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadeAno(anoS)) {
//			System.out.println("\nDigite um ano v�lido:");
//			anoS = teclado.next();
//			teclado.nextLine();
//		}
//
//		int ano = Integer.parseInt(anoS);
//
//		System.out.println(
//				"\nDigite a quilometragem atual do carro no momento deste cadastro: \nDigite 0 para sair do metodo: ");
//		String quilometragemAtualS = teclado.next();
//		teclado.nextLine();
//
//		if (quilometragemAtualS.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().validadeKm(quilometragemAtualS)) {
//			System.out.println("\nDigite uma quilometragem valida:");
//			quilometragemAtualS = teclado.next();
//			teclado.nextLine();
//		}
//
//		int quilometragemAtual = Integer.parseInt(quilometragemAtualS);
//
//		try {
//			ControladorVeiculo.getCtrlVeiculo().alterar(placa, placaAtt, modelo, marca, ano, quilometragemAtual);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			System.out.println(ControladorVeiculo.getCtrlVeiculo().exibeUmVeiculo(placaAtt));
//		} catch (VeiculoException e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	private void removerVeiculo() {
//		System.out.println("\nDigite a placa do veiculo a ser removido: \nDigite 0 para sair do metodo: ");
//		String placa = teclado.nextLine();
//
//		if (placa.equals("0")) {
//			return;
//		}
//
//		while (!ControladorVeiculo.getCtrlVeiculo().verificaVeiculoExiste(placa)) {
//			System.out.println("\nDigite uma placa cadastrada: ");
//			placa = teclado.nextLine();
//		}
//
//		try {
//			ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().removeVeiculoDosFuncionarios(placa);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		try {
//			ControladorVeiculo.getCtrlVeiculo().excluir(placa);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	// List method
//
//	private void listaVeiculos() {
//		try {
//			System.out.println(ControladorVeiculo.getCtrlVeiculo().lista());
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//	}
//
//}