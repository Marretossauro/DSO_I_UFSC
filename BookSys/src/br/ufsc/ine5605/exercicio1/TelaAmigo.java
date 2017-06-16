package br.ufsc.ine5605.exercicio1;

import java.util.Scanner;

public class TelaAmigo {

	private Scanner teclado;
	private ControladorAmigo ctrlAmigo;

	public TelaAmigo(ControladorAmigo ctrlAmigo) {
		teclado = new Scanner(System.in);
		this.ctrlAmigo = ctrlAmigo;
	}

	public void exibeMenuInicial() {
		int opcao = 0;

		System.out.println("-------------SisAmigo-------------");
		System.out.println("1-Cadastra Amigo");
		System.out.println("2-Exclui Amigo");
		System.out.println("3-Altera Amigo");
		System.out.println("4-Listar Amigos");
		System.out.println("0-Encerra");
		System.out.println("Escola a opcao");

		opcao = teclado.nextInt();
		/*
		 * Cadastra amigo
		 */
		while (opcao != 0) {
			switch (opcao) {
			case 1:
				/*
				 * CADASTRA AMIGO
				 */
				cadastraAmigo();
				System.out.println("Digite a proxima opção");
				opcao = teclado.nextInt();
				break;
			case 2:
				/*
				 * REMOVER AMIGO
				 */
				removerAmigo();

				System.out.println("Digite a proxima opção");
				opcao = teclado.nextInt();
				break;
			case 3:
				/*
				 * ALTERA AMIGO
				 */
				alteraAmigo();

				System.out.println("Digite a proxima opção");
				opcao = teclado.nextInt();
				break;
			case 4:
				/*
				 * LISTA AMIGOS
				 */
				listaAmigos();

				System.out.println("Digite a proxima opção");
				opcao = teclado.nextInt();
				break;
			}
		}
	}

	private void alteraAmigo() {
		System.out.println("Digite o codigo do amigo a ser alterado");
		int codigo = teclado.nextInt();

		System.out.println("Digite o nome");
		String nome = teclado.next();

		System.out.println("Digite o numero de telefone");
		int numTelefone = teclado.nextInt();

		System.out.println("Digite o email");
		String email = teclado.next();

		Amigo amigo = new Amigo(codigo, nome, numTelefone, email);

		ctrlAmigo.alteraAmigoPeloCodigo(codigo, amigo);
	}

	private void removerAmigo() {
		System.out.println("Digite o codigo do amigo a ser apagado");
		int codigo = teclado.nextInt();

		if (ctrlAmigo.excluiAmigoPeloCodigo(codigo)) {
			System.out.println("Amigo Excluido com sucesso");
		} else {
			System.out.println("Nao foi possivel excluir o amigo");
		}
	}

	private void listaAmigos() {
		System.out.println(ctrlAmigo.exibeListaAmigos(ctrlAmigo.listarAmigos()));
	}

	private void cadastraAmigo() {
		System.out.println("Digite o codigo");
		int codigo = teclado.nextInt();

		System.out.println("Digite o nome");
		String nome = teclado.next();

		System.out.println("Digite o numero de telefone");
		int numTelefone = teclado.nextInt();

		System.out.println("Digite o email");
		String email = teclado.next();

		Amigo amigo = new Amigo(codigo, nome, numTelefone, email);
		ctrlAmigo.incluiAmigo(amigo);

	}
}
