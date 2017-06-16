// package br.ufsc.ine5605.trab1.display;
//
// import java.util.InputMismatchException;
// import br.ufsc.ine5605.trab1.controllers.ControladorEmprestimo;
// import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;
// import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
// import br.ufsc.ine5605.trab1.interfaces.DisplayEx;
//
// public class TelaEmprestimo implements DisplayEx {
//
// // Constructor
//
// public TelaEmprestimo(ControladorEmprestimo ctrlEmprestimo) {
// super();
// }
//
// // Override methods
//
// @Override
// public void exibeMenuPrincipal() {
// System.out.println("-------------SisEmprestimo-------------");
// System.out.println("\n1) Alugar Veiculo");
// System.out.println("2) Devolver Veiculo");
// System.out.println("3) Lista Emprestimos");
// System.out.println("0) Encerra este sistema");
// System.out.println("\nEscolha a opcao: ");
// }
//
// @Override
// public void exibeMenuInicial() {
//
// int opcao = 0;
//
// exibeMenuPrincipal();
//
// try {
// opcao = teclado.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("\nOpcao digitada incorretamente");
// }
// teclado.nextLine();
//
// while (opcao > 0 && opcao < 4 && opcao != 0) {
// switch (opcao) {
// case 1:
// /*
// * CADASTRA FUNCIONARIO
// */
// alugaVeiculo();
// exibeMenuPrincipal();
// try {
// opcao = teclado.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("\nOpcao digitada incorretamente");
// }
// teclado.nextLine();
// break;
// case 2:
// /*
// * REMOVER FUNCIONARIO
// */
// devolveVeiculo();
// exibeMenuPrincipal();
// try {
// opcao = teclado.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("\nOpcao digitada incorretamente");
// }
// teclado.nextLine();
// break;
// case 3:
// /*
// * LISTA EMPRESTIMOS
// */
// listaEmprestimos();
// exibeMenuPrincipal();
// try {
// opcao = teclado.nextInt();
// } catch (InputMismatchException e) {
// System.out.println("\nOpcao digitada incorretamente");
// }
// teclado.nextLine();
// break;
// }
// }
//
// }
//
// // Rent and return methods
//
// public void alugaVeiculo() {
//
// boolean ativo = true;
//
// System.out.println("\nDigite sua matricula: \nDigite 0 para sair do metodo:
// ");
// String numeroMatricula = teclado.next();
// teclado.nextLine();
//
// if (numeroMatricula.equals("0")) {
// return;
// }
//
// if
// (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().validadeMatricula(numeroMatricula)
// ||
// !ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaFuncionarioExiste(numeroMatricula))
// {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso Negado:
// Matricula invalida", numeroMatricula, null);
// ativo = false;
// }
//
// while (ativo) {
//
// String placa = "";
//
// if
// (ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaVeiculoPermitido(numeroMatricula))
// {
//
// System.out.println(
// "\nDigite a placa do veiculo que voce deseja retirar: \nDigite 0 para sair do
// metodo: ");
// placa = teclado.next();
// teclado.nextLine();
//
// if (placa.equals("0")) {
// return;
// }
//
// if
// (!ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadePlaca(placa)
// ||
// !ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa))
// {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso Negado:
// Placa invalida", numeroMatricula, placa);
// ativo = false;
// break;
// }
//
// try {
// ControladorEmprestimo.getCtrlEmprestimo().verficaAdicionaEmprestimo(numeroMatricula,
// placa);
// System.out.println("\nAcesso Permitido: Veiculo na lista e disponivel!");
// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// break;
//
// } else if
// (ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().pegaPrimeiroVeiculo(numeroMatricula)
// .isDisponivel()) {
// ControladorEmprestimo.getCtrlEmprestimo().adicionaEmprestimo(
// ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().buscarPelaMatricula(numeroMatricula),
// ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().pegaPrimeiroVeiculo(numeroMatricula));
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso
// Permitido: Veiculo disponivel", numeroMatricula,
// ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().pegaPrimeiroVeiculo(numeroMatricula).getPlaca());
// System.out.println("\nAcesso Permitido: Veiculo na lista e disponivel!");
// ativo = false;
// break;
// } else {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso Negado:
// Veiculo indisponivel", numeroMatricula,
// ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().pegaPrimeiroVeiculo(numeroMatricula).getPlaca());
// System.out.println("\nVeiculo indisponivel");
// ativo = false;
// break;
// }
//
// }
//
// }
//
// public void devolveVeiculo() {
//
// boolean ativo = true;
//
// while (ativo) {
//
// System.out.println("\nDigite sua matricula: \nDigite 0 para sair do metodo:
// ");
// String numeroMatricula = teclado.next();
// teclado.nextLine();
//
// if (numeroMatricula.equals("0")) {
// return;
// }
//
// if
// (!ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().validadeMatricula(numeroMatricula)
// || !ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
// .verificaFuncionarioExiste(numeroMatricula)) {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso Negado:
// Matricula invalida",
// numeroMatricula, null);
// }
//
// System.out.println("\nDigite a placa do veiculo que sera devolvido: \nDigite
// 0 para sair do metodo: ");
// String placa = teclado.next();
// teclado.nextLine();
//
// if (placa.equals("0")) {
// return;
// }
//
// if
// (!ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadePlaca(placa)
// ||
// !ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa))
// {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Acesso Negado:
// Placa invalida",
// numeroMatricula, placa);
// System.out.println("\nAcesso negado: Placa invalida");
// ativo = false;
// break;
// }
//
// String quilometragemAtualS = "";
//
// if
// (ControladorEmprestimo.getCtrlEmprestimo().verificaValidadeEmprestimo(numeroMatricula,
// placa)) {
// System.out.println("\nDigite a quilometragem atual total: \nDigite 0 para
// sair do metodo: ");
// quilometragemAtualS = teclado.next();
// teclado.nextLine();
//
// if (quilometragemAtualS.equals("0")) {
// return;
// }
//
// if
// (!ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadeKm(quilometragemAtualS))
// {
// ControladorPrincipal.getCtrlPrincipal().getCtrlLog()
// .criaLog("Devolucao negada: Quilometragem invalida", numeroMatricula, placa);
// System.out.println("\nDevolucao negada: Quilometragem invalida");
// ativo = false;
// break;
// } else {
// int quilometragemAtual = Integer.parseInt(quilometragemAtualS);
// try {
// ControladorEmprestimo.getCtrlEmprestimo().verificaEmp(quilometragemAtual,
// numeroMatricula,
// placa);
// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// System.out.println("\nDevolucao efetuada com sucesso: Veiculo Devolvido");
// ativo = false;
// break;
// }
// }
// }
// }
//
// // List method
//
// public void listaEmprestimos() {
// try {
// System.out.println(ControladorEmprestimo.getCtrlEmprestimo().listarEmprestimos());
// } catch (ListaVaziaException e) {
// System.out.println(e.getMessage());
// }
// }
//
// }
