package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaEmpPrinc;
import br.ufsc.ine5605.trab1.display.TelaEmprestimo;
import br.ufsc.ine5605.trab1.exceptions.AcessoBloqueadoException;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
import br.ufsc.ine5605.trab1.exceptions.VeiculoException;
import br.ufsc.ine5605.trab1.objects.Emprestimo;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.Veiculo;
import br.ufsc.ine5605.trab1.persistencia.EmprestimoDAO;

public class ControladorEmprestimo extends Controlador {

	// private ArrayList<Emprestimo> listaEmprestimos;

	private static ControladorEmprestimo ctrlEmprestimo;
	private TelaEmprestimo telaEmprestimo;
	private TelaEmpPrinc telaEmpPrinc;
	private int codigoDoEmprestimo = 0;

	// Constructor

	public ControladorEmprestimo() {
		super();
		// this.listaEmprestimos = new ArrayList<>();
		telaEmprestimo = new TelaEmprestimo(this);
		telaEmpPrinc = new TelaEmpPrinc(this);
		
	}

	// Override method

	@Override
	public void inicia() {
		//telaEmprestimo.exibeMenuInicial();
		telaEmpPrinc.setVisible(true);
	}

	// Create, end and list methods

	public void adicionaEmprestimo(Funcionario usuario, Veiculo utilitario) {
		Emprestimo emp = new Emprestimo(usuario, utilitario);
		utilitario.setDisponibilidade(false);
		codigoDoEmprestimo++;
		emp.setCodigo(codigoDoEmprestimo);
		EmprestimoDAO.getEmpDAO().put(emp);
	}

	public void encerraEmprestimo(int codigoDoEmprestimo) {
		if (verificaEmprestimoExiste(codigoDoEmprestimo)) {
			buscarPeloCodigo(codigoDoEmprestimo).getUtilitario().setDisponibilidade(true);
			EmprestimoDAO.getEmpDAO().remove(codigoDoEmprestimo);
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

	public void verficaAdicionaEmprestimo(String numeroMatricula, String placa) throws Exception {

		if (ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula).getTentativas() == 3) {
			ControladorLog.getCtrlLog().criaLog("Acesso Negado: Acesso Bloqueado", numeroMatricula, placa);
			throw new AcessoBloqueadoException();
		} else {
			for (Veiculo v : ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
					.getListaDeCarrosLiberados()) {
				if (v.getPlaca().equals(placa)) {
					if (v.isDisponivel()) {
						adicionaEmprestimo(
								ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula),
								ControladorVeiculo.getCtrlVeiculo().buscarPelaPlaca(placa));
						ControladorLog.getCtrlLog().criaLog("Acesso Permitido: Veiculo na lista e disponivel",
								numeroMatricula, placa);
						ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
								.setTentativas(0);
						return;
					} else {
						ControladorLog.getCtrlLog().criaLog("Acesso Negado: Veiculo indisponivel", numeroMatricula,
								placa);
						throw new VeiculoException("\nAcesso Negado: Veiculo indisponivel");
					}
				}
			}

			ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula).addTentativa();
			ControladorLog.getCtrlLog().criaLog(
					"Acesso Negado: O funcionario nao possui permissao para usar este veiculo", numeroMatricula, placa);
			throw new VeiculoException(
					"\nAcesso Negado: O funcionario nao possui permissao para usar este veiculo \nAo chegar em 3 tentativas, o acesso sera bloqueado \nO funcionario tentou "
							+ ControladorFuncionario.getCtrlFuncionario().buscarPelaMatricula(numeroMatricula)
									.getTentativas()
							+ " vezes");

		}

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
