package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaEmpPrinc;
import br.ufsc.ine5605.trab1.display.TelaEncEmp;
import br.ufsc.ine5605.trab1.display.TelaListaEmp;
import br.ufsc.ine5605.trab1.display.TelaRealEmp;
import br.ufsc.ine5605.trab1.exceptions.AcessoBloqueadoException;
import br.ufsc.ine5605.trab1.exceptions.FuncionarioException;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
import br.ufsc.ine5605.trab1.exceptions.VeiculoException;
import br.ufsc.ine5605.trab1.objects.Emprestimo;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.Veiculo;
import br.ufsc.ine5605.trab1.persistencia.EmprestimoDAO;

public class ControladorEmprestimo extends Controlador {

	// private ArrayList<Emprestimo> listaEmprestimos;

	private static ControladorEmprestimo ctrlEmprestimo;
	// private TelaEmprestimo telaEmprestimo;
	private TelaEmpPrinc telaEmpPrinc;
	private TelaRealEmp telaRE;
	private TelaEncEmp telaEncEmp;
	private TelaListaEmp telaListaEmp;
	private int codigoDoEmprestimo = 0;

	// Constructor

	public ControladorEmprestimo() {
		super();
		// this.listaEmprestimos = new ArrayList<>();
		// telaEmprestimo = new TelaEmprestimo(this);
		telaEmpPrinc = new TelaEmpPrinc(this);
		telaRE = new TelaRealEmp(this);
		telaEncEmp = new TelaEncEmp(this);
		telaListaEmp = new TelaListaEmp(this);
	}

	// Override method

	@Override
	public void inicia() {
		// telaEmprestimo.exibeMenuInicial();
		telaEmpPrinc.setVisible(true);
	}

	// Create, end and list methods

	public void adicionaEmprestimo(String numeroMatricula, String placa) throws Exception {
		if (ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaFuncionarioExiste(numeroMatricula)) {
			if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa)) {
				if (verificaPerm(numeroMatricula, placa) && ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
						.buscarPelaMatricula(numeroMatricula).getTentativas() < 3) {
					if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa)
							.isDisponivel()) {
						Emprestimo emp = new Emprestimo(
								ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
										.buscarPelaMatricula(numeroMatricula),
								ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa));
						ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa)
								.setDisponibilidade(false);
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
								.buscarPelaMatricula(numeroMatricula).setTentativas(0);
						codigoDoEmprestimo++;
						emp.setCodigo(codigoDoEmprestimo);
						EmprestimoDAO.getEmpDAO().put(emp);
						telaListaEmp.updateData();
						ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().getVeicDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().updateTelaListaVeicData();
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().getFuncDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().updateTelaListaFuncData();
						for (Funcionario f : ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().getFuncDAO()
								.getList()) {
							ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
									.updateTelaListVeicFuncData(f.getNumeroMatricula());
						}
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog()
								.criaLog("Acesso Permitido: Veiculo permitido e disponivel", numeroMatricula, placa);
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().getLogDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().updateTelaListaLogData();
					} else {
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog()
								.criaLog("Acesso Negado: Veiculo indisponivel", numeroMatricula, placa);
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().getLogDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().updateTelaListaLogData();
						throw new Exception("O veiculo nao esta disponivel");
					}
				} else {
					if (ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
							.buscarPelaMatricula(numeroMatricula).getTentativas() < 3) {
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog(
								"Acesso Negado: O funcionario nao possui esta permissao", numeroMatricula, placa);
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().getLogDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().updateTelaListaLogData();
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
								.buscarPelaMatricula(numeroMatricula).addTentativa();
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().getFuncDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().updateTelaListaFuncData();
						throw new Exception("O Funcionario nao possui permissao para este veiculo");
					} else {
						ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
								.buscarPelaMatricula(numeroMatricula).setBloqueado(true);
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog()
								.criaLog("Acesso Negado: O Funcionario esta bloqueado", numeroMatricula, placa);
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().getLogDAO().persist();
						ControladorPrincipal.getCtrlPrincipal().getCtrlLog().updateTelaListaLogData();
						throw new AcessoBloqueadoException("O Funcionario esta bloqueado");
					}
				}
			} else {
				throw new VeiculoException("Veiculo inexistente");
			}
		} else {
			throw new FuncionarioException("Funcionario inexistente");
		}
	}

	public void encerraEmprestimo(int codigoDoEmprestimo) throws Exception {
		if (verificaEmprestimoExiste(codigoDoEmprestimo)) {
			ControladorPrincipal.getCtrlPrincipal().getCtrlLog().criaLog("Veiculo devolvido",
					buscarPeloCodigo(codigoDoEmprestimo).getUsuario().getNumeroMatricula(),
					buscarPeloCodigo(codigoDoEmprestimo).getUtilitario().getPlaca());
			ControladorPrincipal.getCtrlPrincipal().getCtrlLog().getLogDAO().persist();
			ControladorPrincipal.getCtrlPrincipal().getCtrlLog().updateTelaListaLogData();
			buscarPeloCodigo(codigoDoEmprestimo).getUtilitario().setDisponibilidade(true);
			ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().getVeicDAO().persist();
			ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().updateTelaListaVeicData();
			EmprestimoDAO.getEmpDAO().remove(codigoDoEmprestimo);
			telaListaEmp.updateData();
		} else {
			throw new Exception("Emprestimo nao existente");
		}
	}

	public String listarEmprestimos() throws ListaVaziaException {
		String listaDeEmp = "";
		if (!EmprestimoDAO.getEmpDAO().getList().isEmpty()) {
			for (Emprestimo e : EmprestimoDAO.getEmpDAO().getList()) {
				listaDeEmp += ("\nCodigo do emprestimo: " + e.getCodigo() + "\nPlaca do veiculo: "
						+ e.getUtilitario().getPlaca() + "\nNome do funcionario responsavel: "
						+ e.getUsuario().getNome() + "\nMatricula do funcionario responsavel: "
						+ e.getUsuario().getNumeroMatricula() + "\n");
			}
		} else {
			throw new ListaVaziaException("\nNao ha emprestimos cadastrados");
		}
		return listaDeEmp;
	}

	// Search method

	public Emprestimo buscarPeloCodigo(int codigoDoEmprestimo) {
		if (verificaEmprestimoExiste(codigoDoEmprestimo)) {
			for (Emprestimo e : EmprestimoDAO.getEmpDAO().getList()) {
				if (e.getCodigo() == codigoDoEmprestimo) {
					return e;
				}
			}
		}
		return null;
	}

	// Verifications

	public boolean verificaValidadeEmprestimo(String numeroMatricula, String placa) {

		boolean validade = false;

		for (Emprestimo e : EmprestimoDAO.getEmpDAO().getList()) {
			if (e.getUsuario().getNumeroMatricula().equals(numeroMatricula)
					&& e.getUtilitario().getPlaca().equals(placa)) {
				validade = true;
			}
		}

		return validade;

	}

	public boolean verificaEmprestimoExiste(int codigoDoEmprestimo) {
		if (!EmprestimoDAO.getEmpDAO().getList().isEmpty()) {
			for (Emprestimo e : EmprestimoDAO.getEmpDAO().getList()) {
				if (e.getCodigo() == codigoDoEmprestimo) {
					return true;
				}
			}
		}
		return false;
	}

	public void verificaEmp(int quilometragemAtual, String numeroMatricula, String placa) throws Exception {

		for (Emprestimo e : EmprestimoDAO.getEmpDAO().getList()) {
			if (e.getUsuario().getNumeroMatricula().equalsIgnoreCase(numeroMatricula)
					&& e.getUtilitario().getPlaca().equalsIgnoreCase(placa)
					&& quilometragemAtual >= e.getUtilitario().getQuilometragemAtual()
					&& !e.getUtilitario().isDisponivel()) {
				e.getUtilitario().setQuilometragemAtual(quilometragemAtual);
				ControladorEmprestimo.getCtrlEmprestimo().encerraEmprestimo(e.getCodigo());
				ControladorLog.getCtrlLog().criaLog("Devolucao efetuada com sucesso: Veiculo Devolvido",
						numeroMatricula, placa);
				break;
			} else {
				ControladorLog.getCtrlLog().criaLog("Devolucao negada: Quilometragem menor que a anterior",
						numeroMatricula, placa);
				throw new VeiculoException("Devolucao negada: Quilometragem menor que a anterior");
			}
		}

	}

	// public void verficaAdicionaEmprestimo(String numeroMatricula, String
	// placa) throws Exception {
	//
	// if
	// (ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula).getTentativas()
	// == 3) {
	// ControladorLog.getCtrlLog().criaLog("Acesso Negado: Acesso Bloqueado",
	// numeroMatricula, placa);
	// throw new AcessoBloqueadoException();
	// } else {
	// for (Veiculo v :
	// ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
	// .getListaDeCarrosLiberados()) {
	// if (v.getPlaca().equals(placa)) {
	// if (v.isDisponivel()) {
	// adicionaEmprestimo(
	// ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula),
	// ControladorVeiculo.getCtrlVeiculo().buscarPelaPlaca(placa));
	// ControladorLog.getCtrlLog().criaLog("Acesso Permitido: Veiculo na lista e
	// disponivel",
	// numeroMatricula, placa);
	// ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
	// .setTentativas(0);
	// return;
	// } else {
	// ControladorLog.getCtrlLog().criaLog("Acesso Negado: Veiculo
	// indisponivel", numeroMatricula,
	// placa);
	// throw new VeiculoException("\nAcesso Negado: Veiculo indisponivel");
	// }
	// }
	// }
	//
	// ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula).addTentativa();
	// ControladorLog.getCtrlLog().criaLog(
	// "Acesso Negado: O funcionario nao possui permissao para usar este
	// veiculo", numeroMatricula, placa);
	// throw new VeiculoException(
	// "\nAcesso Negado: O funcionario nao possui permissao para usar este
	// veiculo \nAo chegar em 3 tentativas, o acesso sera bloqueado \nO
	// funcionario tentou "
	// +
	// ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
	// .getTentativas()
	// + " vezes");
	//
	// }
	//
	// }

	public boolean verificaPerm(String numeroMatricula, String placa) {
		if (ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().verificaFuncionarioExiste(numeroMatricula)
				&& ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa)) {
			for (Veiculo veiculo : ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario()
					.buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()) {
				if (veiculo.getPlaca().equals(placa)) {
					return true;
				}
			}
		}
		return false;
	}

	// Window method

	public void telaRE() {
		telaRE.setVisible(true);
	}

	public void telaEncEmp() {
		telaEncEmp.setVisible(true);
	}

	public void telaListaEmp() {
		telaListaEmp.setVisible(true);
	}

	// Getters & Setters

	public EmprestimoDAO getEmpDAO() {
		return EmprestimoDAO.getEmpDAO();
	}

	public static ControladorEmprestimo getCtrlEmprestimo() {
		if (ctrlEmprestimo == null) {
			ctrlEmprestimo = new ControladorEmprestimo();
		}
		return ctrlEmprestimo;
	}

	public static void setCtrlEmprestimo(ControladorEmprestimo ctrlEmprestimo) {
		ControladorEmprestimo.ctrlEmprestimo = ctrlEmprestimo;
	}

	public ArrayList<Emprestimo> getListaEmprestimos() {
		return new ArrayList<Emprestimo>(EmprestimoDAO.getEmpDAO().getList());
	}

}
