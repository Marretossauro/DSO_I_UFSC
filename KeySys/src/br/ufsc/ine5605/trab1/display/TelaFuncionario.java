//package br.ufsc.ine5605.trab1.display;
//
//import java.util.InputMismatchException;
//import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
//import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;
//import br.ufsc.ine5605.trab1.exceptions.FuncionarioException;
//import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
//import br.ufsc.ine5605.trab1.interfaces.DisplayEx;
//
//public class TelaFuncionario implements DisplayEx {
//
//	// Constructor
//
//	public TelaFuncionario(ControladorFuncionario ctrlFuncionario) {
//		super();
//	}
//
//	// Override methods
//
//	@Override
//	public void exibeMenuPrincipal() {
//		System.out.println("-------------SisFuncionario-------------");
//		System.out.println("\n1) Cadastra Funcionario");
//		System.out.println("2) Exclui Funcionario");
//		System.out.println("3) Altera Funcionario");
//		System.out.println("4) Lista Funcionarios");
//		System.out.println("5) Lista Veiculos Permitidos por matricula");
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
//		while (opcao > 0 && opcao < 6 && opcao != 0) {
//			switch (opcao) {
//			case 1:
//				/*
//				 * CADASTRA FUNCIONARIO
//				 */
//				cadastraFuncionario();
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
//				 * REMOVER FUNCIONARIO
//				 */
//				removerFuncionario();
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
//				 * ALTERA FUNCIONARIO
//				 */
//				alteraFuncionario();
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
//				 * LISTA FUNCIONARIO
//				 */
//				listaFuncionarios();
//				exibeMenuPrincipal();
//				try {
//					opcao = teclado.nextInt();
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente");
//				}
//				teclado.nextLine();
//				break;
//			case 5:
//				listaVeiculosLiberados();
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
//	// Add, remove and update methods
//
//	private void cadastraFuncionario() {
//
//		System.out.println(
//				"\nDigite um numero de matricula desejado que tenha 4 numeros: \nDigite 0 para sair do metodo: ");
//		String numeroMatricula = teclado.next();
//		teclado.nextLine();
//
//		if (numeroMatricula.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().validadeMatricula(numeroMatricula)
//				|| ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//						.verificaFuncionarioExiste(numeroMatricula)) {
//			System.out.println("\nDigite uma matricula valida e inexistente: ");
//			numeroMatricula = teclado.next();
//			teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o nome: \nDigite S para sair do metodo: ");
//		String nome = teclado.nextLine();
//
//		if (nome.length() == 1 && nome.charAt(0) == 'S' || nome.length() == 1 && nome.charAt(0) == 's') {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaNome(nome)) {
//			System.out.println("\nDigite um nome valido: ");
//			nome = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o numero de telefone: \nDigite 0 para sair do metodo: ");
//		String telefone = teclado.nextLine();
//
//		if (telefone.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaTelefone(telefone)) {
//			System.out.println("\nDigite um numero de telefone valido: ");
//			telefone = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite a data de nascimento em formato dd/MM/aaaa: \nDigite 0 para sair do metodo: ");
//		String dataDeNascimento = teclado.next();
//		teclado.nextLine();
//
//		if (dataDeNascimento.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaData(dataDeNascimento)) {
//			System.out.println("\nDigite uma data em formato valido: ");
//			dataDeNascimento = teclado.next();
//			teclado.nextLine();
//		}
//
//		System.out.println("\nDefina o cargo, sabendo que: \n");
//		System.out.println("1 - Diretoria\n2 - Financeiro\n3 - Limpeza\n4 - Marketing\n5 - RH\n6 - Seguranca\n");
//		int opcao = 0;
//		try {
//			opcao = teclado.nextInt();
//		} catch (InputMismatchException e) {
//			System.out.println("Opcao digitada incorretamente");
//		}
//		teclado.nextLine();
//
//		while (opcao < 1 || opcao > 6) {
//			System.out.println("Escolha um digito entre 1 e 6");
//			opcao = teclado.nextInt();
//			teclado.nextLine();
//		}
//
//		char opcaoc = ' ';
//		String placa = "";
//
//		ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().recebeDados(numeroMatricula, nome,
//				dataDeNascimento, telefone, opcao);
//
//		if (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaCargoDiretoria(ControladorPrincipal
//				.getCtrlPrincipal().getCtrlFuncionario().buscarPelaMatricula(numeroMatricula).getCargo())) {
//			do {
//				System.out.println(
//						"\nDigite a placa do veiculo para adicionar a permissao: \nDigite 0 para sair do metodo: ");
//				placa = teclado.nextLine();
//
//				if (placa.equals("0")) {
//					return;
//				}
//
//				while (!ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadePlaca(placa)
//						|| !ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa)) {
//					System.out.println("\nDigite uma placa valida e ja cadastrada: ");
//					placa = teclado.nextLine();
//				}
//
//				try {
//					ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
//							.addVeiculo(
//									ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa));
//				} catch (IllegalArgumentException e) {
//					System.out.println(e.getMessage());
//				}
//
//				System.out.println("\nDeseja adicionar outro veiculo aos permitidos? (Responda com S/N)");
//				try {
//					opcaoc = teclado.next().charAt(0);
//				} catch (InputMismatchException e) {
//					System.out.println("\nOpcao digitada incorretamente\n");
//				}
//				teclado.nextLine();
//			} while (opcaoc == 'S' || opcaoc == 's');
//		} else {
//			ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
//					.getListaDeCarrosLiberados()
//					.addAll(ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().listarVeiculos());
//		}
//
//		listaFuncionarios();
//
//		try {
//			System.out.println(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//					.exibeListaDeCarrosLiberados(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//							.listarCarrosLiberados(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//									.buscarPelaMatricula(numeroMatricula))));
//		} catch (ListaVaziaException e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	private void alteraFuncionario() {
//		System.out.println("\nDigite a matricula do funcionario a ser alterado: \nDigite 0 para sair do metodo: ");
//		String numeroMatricula = teclado.next();
//		teclado.nextLine();
//
//		if (numeroMatricula.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().validadeMatricula(numeroMatricula)
//				|| !ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//						.verificaFuncionarioExiste(numeroMatricula)) {
//			System.out.println("\nDigite uma matricula existente: ");
//			numeroMatricula = teclado.next();
//			teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o nome: \nDigite S para sair do metodo: ");
//		String nome = teclado.nextLine();
//
//		if (nome.charAt(0) == 'S' || nome.charAt(0) == 's') {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaNome(nome)) {
//			System.out.println("\nDigite um nome valido: ");
//			nome = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite o numero do telefone: \nDigite 0 para sair do metodo: ");
//		String telefone = teclado.nextLine();
//
//		if (telefone.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaTelefone(telefone)) {
//			System.out.println("\nDigite um numero de telefone valido: ");
//			telefone = teclado.nextLine();
//		}
//
//		System.out.println("\nDigite a data de nascimento em formato dd/MM/aaaa: \nDigite 0 para sair do metodo: ");
//		String dataDeNascimento = teclado.next();
//		teclado.nextLine();
//
//		if (dataDeNascimento.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaData(dataDeNascimento)) {
//			System.out.println("\nDigite uma data em formato valido: ");
//			dataDeNascimento = teclado.next();
//			teclado.nextLine();
//		}
//
//		System.out.println("\nEscolha o cargo, sabendo que: \n");
//		System.out.println("1 - Diretoria\n2 - Financeiro\n3 - Limpeza\n4 - Marketing\n5 - RH\n6 - Seguranca\n");
//		int opcaoc = teclado.nextInt();
//		teclado.nextLine();
//
//		while (opcaoc < 1 || opcaoc > 6) {
//			System.out.println("\nEscolha um digito entre 1 e 6");
//			opcaoc = teclado.nextInt();
//			teclado.nextLine();
//		}
//
//		try {
//			ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().alterar(numeroMatricula, nome,
//					dataDeNascimento, telefone, opcaoc);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//		String placa = "";
//		char opcaoAdicionarVeiculo = ' ';
//
//		do {
//			System.out.println(
//					"\nDigite 1 para adicionar um veiculo: \n2 para excluir um veiculo: \n3 para continuar: \nEscolha sua opcao: ");
//			int opcao = teclado.nextInt();
//			teclado.nextLine();
//			try {
//				switch (opcao) {
//				case 1:
//					System.out.println("\nDigite a placa do veiculo que deseja adicionar: ");
//					placa = teclado.nextLine();
//					try {
//						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//								.buscarPelaMatricula(numeroMatricula).addVeiculo(ControladorPrincipal.getCtrlPrincipal()
//										.getCtrlVeiculo().buscarPelaPlaca(placa));
//					} catch (IllegalArgumentException e) {
//						System.out.println(e.getMessage());
//					}
//					break;
//				case 2:
//					System.out.println("\nDigite a placa do veiculo que deseja excluir: ");
//					placa = teclado.nextLine();
//					try {
//						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//								.buscarPelaMatricula(numeroMatricula).delVeiculo(ControladorPrincipal.getCtrlPrincipal()
//										.getCtrlVeiculo().buscarPelaPlaca(placa));
//					} catch (FuncionarioException e) {
//						System.out.println(e.getMessage());
//					}
//					break;
//				case 3:
//					break;
//				}
//			} catch (InputMismatchException e) {
//				System.out.println("\nOpcao digitada incorretamente");
//			} catch (Exception e) {
//				System.out.println("Erro: " + e.getMessage() + "Local: TelaFuncionario.alterar() ");
//				e.printStackTrace();
//			}
//			System.out.println("\nDeseja alterar outro veiculo nos permitidos? (Responda com S/N)");
//			opcaoAdicionarVeiculo = teclado.next().charAt(0);
//		} while (opcaoAdicionarVeiculo == 'S' || opcaoAdicionarVeiculo == 's');
//
//		try {
//			System.out.println(
//					ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().exibeUmFuncionario(numeroMatricula));
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	private void removerFuncionario() {
//		System.out.println("\nDigite a matricula do funcionario a ser apagado: \nDigite 0 para sair do metodo: ");
//
//		String numeroMatricula = teclado.next();
//		teclado.nextLine();
//
//		if (numeroMatricula.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//				.verificaFuncionarioExiste(numeroMatricula)) {
//			System.out.println("\nDigite uma matricula existente: ");
//			numeroMatricula = teclado.next();
//			teclado.nextLine();
//		}
//
//		try {
//			ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().excluir(numeroMatricula);
//		} catch (Exception e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	// List methods
//
//	private void listaFuncionarios() {
//
//		try {
//			System.out.println(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().lista());
//		} catch (ListaVaziaException e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//	private void listaVeiculosLiberados() {
//
//		System.out.println("\nDigite o numero de matricula do funcionario: \nDigite 0 para sair do metodo: ");
//		String numeroMatricula = teclado.next();
//		teclado.nextLine();
//
//		if (numeroMatricula.equals("0")) {
//			return;
//		}
//
//		while (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().validadeMatricula(numeroMatricula)
//				|| !ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//						.verificaFuncionarioExiste(numeroMatricula)) {
//			System.out.println("\nDigite uma matricula existente: ");
//			numeroMatricula = teclado.next();
//			teclado.nextLine();
//		}
//
//		try {
//			System.out.println(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//					.exibeListaDeCarrosLiberados(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//							.listarCarrosLiberados(ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
//									.buscarPelaMatricula(numeroMatricula))));
//		} catch (ListaVaziaException e) {
//			System.out.println(e.getMessage());
//		}
//
//	}
//
//}
