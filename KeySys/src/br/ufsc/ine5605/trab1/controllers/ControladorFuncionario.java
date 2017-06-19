package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;


import br.ufsc.ine5605.trab1.display.TelaAddVeicFunc;
import br.ufsc.ine5605.trab1.display.TelaAlterarFunc;
import br.ufsc.ine5605.trab1.display.TelaCadastroFunc;
import br.ufsc.ine5605.trab1.display.TelaChamaListar;
import br.ufsc.ine5605.trab1.display.TelaExcluirFunc;
import br.ufsc.ine5605.trab1.display.TelaFuncPrinc;
import br.ufsc.ine5605.trab1.display.TelaListaFunc;
import br.ufsc.ine5605.trab1.display.TelaListaVeicFunc;
import br.ufsc.ine5605.trab1.exceptions.FuncionarioException;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
import br.ufsc.ine5605.trab1.exceptions.VeiculoException;
import br.ufsc.ine5605.trab1.interfaces.IRucd;
import br.ufsc.ine5605.trab1.objects.Emprestimo;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.TipoCargo;
import br.ufsc.ine5605.trab1.objects.Veiculo;
import br.ufsc.ine5605.trab1.persistencia.FuncionarioDAO;

public class ControladorFuncionario extends Controlador implements IRucd {


	private TelaFuncPrinc telaFuncPrinc;
	private TelaCadastroFunc telaCadFunc;
	private TelaListaFunc telaListaFunc;
	private TelaAlterarFunc telaAlteraFunc;
	private TelaExcluirFunc telaExcluiFunc;
	private TelaChamaListar telaChamaList;
	private TelaListaVeicFunc telaListVeicFunc;
	private TelaAddVeicFunc telaAddVeicFunc;
	private static ControladorFuncionario ctrlFuncionario;

	// Constructor

	public ControladorFuncionario() {
		super();
		telaFuncPrinc = new TelaFuncPrinc(this);
		telaCadFunc = new TelaCadastroFunc(this);
		telaListaFunc = new TelaListaFunc(this);
		telaAlteraFunc = new TelaAlterarFunc(this);
		telaExcluiFunc = new TelaExcluirFunc(this);
		telaChamaList = new TelaChamaListar(this);
		telaListVeicFunc = new TelaListaVeicFunc(this);
		telaAddVeicFunc = new TelaAddVeicFunc(this);
	}

	// Override methods

	@Override
	public void inicia() {
		telaFuncPrinc.setVisible(true);
	}

	@Override
	public void cadastrar(Object funcionario) throws IllegalArgumentException {
		Funcionario func = (Funcionario) funcionario;
		if (func != null) {
			if (!FuncionarioDAO.getFuncDAO().getList().isEmpty()) {
				if (!verificaFuncionarioExiste(func.getNumeroMatricula())) {
					FuncionarioDAO.getFuncDAO().put(func);
					telaListaFunc.updateData();
				} else {
					throw new IllegalArgumentException("Funcionario existente");
				}
			} else {
				FuncionarioDAO.getFuncDAO().put(func);
				telaListaFunc.updateData();
			}
		} else {
			throw new IllegalArgumentException("Funcionario Nulo");
		}
	}

	@Override
	public void excluir(String numeroMatricula) throws Exception {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			FuncionarioDAO.getFuncDAO().remove(numeroMatricula);
			telaListaFunc.updateData();
		} else {
			throw new FuncionarioException("\nFuncionario inexistente");
		}
	}

	// Update method

	public void alterar(String numeroMatricula, String nome, String dataDeNascimento, String telefone, int opcaoc)
			throws Exception {
		Funcionario func = buscarPelaMatricula(numeroMatricula);
		if (func != null) {
			if (!FuncionarioDAO.getFuncDAO().getList().isEmpty()) {
				func.setNome(nome);
				func.setDataNascimento(dataDeNascimento);
				func.setTelefone(telefone);
				cadastraCargo(opcaoc, func);
				func.setNumeroMatricula(numeroMatricula);
				FuncionarioDAO.getFuncDAO().persist();
				telaListaFunc.updateData();
			} else {
				throw new ListaVaziaException("\nNao ha funcionarios cadastrados");
			}
		} else {
			throw new IllegalArgumentException("\nFuncionario Nulo");
		}
	}

	// Receives data method

	public void recebeDados(String numeroMatricula, String nome, String dataNascimento, String telefone, int opcaoCargo)
			throws IllegalArgumentException {
		Funcionario func = new Funcionario(numeroMatricula, nome, dataNascimento, telefone);
		cadastrar(func);
		cadastraCargo(opcaoCargo, func);
	}

	// List and Exhibit methods

	public ArrayList<Veiculo> listarCarrosLiberados(String matricula) {
		return buscarPelaMatricula(matricula).getListaDeCarrosLiberados();
	}

	public ArrayList<Funcionario> listarFuncionarios() {
		return new ArrayList<Funcionario>(FuncionarioDAO.getFuncDAO().getList());
	}

	// Register job role method

	public void cadastraCargo(int opcao, Funcionario f) {
		switch (opcao) {
		case 1:
			f.setCargo(TipoCargo.DIRETORIA);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		case 2:
			f.setCargo(TipoCargo.FINANCEIRO);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		case 3:
			f.setCargo(TipoCargo.LIMPEZA);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		case 4:
			f.setCargo(TipoCargo.MARKETING);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		case 5:
			f.setCargo(TipoCargo.RH);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		case 6:
			f.setCargo(TipoCargo.SEGURANCA);
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			break;
		}
	}

	// Verifications

	public boolean validadeMatricula(String numeroMatricula) {
		boolean validade = false;

		if (numeroMatricula.matches("\\d{4}") && !numeroMatricula.equalsIgnoreCase("0000")) {
			validade = true;
		}

		return validade;
	}

	public boolean verificaFuncionarioExiste(String numeroMatricula) {
		if (!FuncionarioDAO.getFuncDAO().getList().isEmpty()) {
			for (Funcionario f : FuncionarioDAO.getFuncDAO().getList()) {
				if (f.getNumeroMatricula().equalsIgnoreCase(numeroMatricula)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean verificaNome(String n) {

		boolean validade = false;

		if (n.length() >= 3) {
			for (int i = 0; i < n.length(); i++) {
				if (Character.isAlphabetic(n.charAt(i)) || Character.isWhitespace(n.charAt(i))) {
					validade = true;
				}
			}
		}
		return validade;
	}

	public boolean verificaData(String dataDeNascimento) {
		boolean validade = false;

		if (dataDeNascimento.matches("\\d{2}/\\d{2}/\\d{4}") && !dataDeNascimento.substring(0, 1).equalsIgnoreCase("00")
				&& !dataDeNascimento.substring(3, 4).equalsIgnoreCase("00")
				&& !dataDeNascimento.substring(6, dataDeNascimento.length()).equalsIgnoreCase("0000")) {
			validade = true;
		}
		return validade;
	}

	public boolean verificaTelefone(String telefone) {

		boolean validade = false;

		if (!(telefone.length() < 8)) {
			for (int i = 0; i < telefone.length(); i++) {
				if (Character.isDigit(telefone.charAt(i)) || Character.isWhitespace(telefone.charAt(i))
						|| (telefone.charAt(i) == '-') || (telefone.charAt(i) == '(') || (telefone.charAt(i) == ')')
						|| (telefone.charAt(i) == '+')) {
					validade = true;
				} else {
					return false;
				}
			}
		}
		return validade;
	}

	public boolean verificaVeiculoPermitido(String numeroMatricula) {

		boolean validade = false;

		if (buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados().size() >= 2) {
			validade = true;
		}

		return validade;
	}

	public boolean verificaCargoDiretoria(TipoCargo cargo) {

		boolean validade = false;
		if (cargo == TipoCargo.DIRETORIA) {
			validade = true;
		}

		return validade;

	}

	// Search method

	public Funcionario buscarPelaMatricula(String numeroMatricula) {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			for (Funcionario f : FuncionarioDAO.getFuncDAO().getList()) {
				if (f.getNumeroMatricula().equalsIgnoreCase(numeroMatricula)) {
					return f;
				}
			}
		}
		return null;
	}

	// Void & Direct Object methods

	public void adicionaSeDiretor(String numeroMatricula) {
		if (verificaCargoDiretoria(buscarPelaMatricula(numeroMatricula).getCargo())) {
			buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()
					.addAll(ControladorVeiculo.getCtrlVeiculo().getVeicDAO().getList());
			FuncionarioDAO.getFuncDAO().persist();
			telaListaFunc.updateData();
			telaListVeicFunc.updateData(numeroMatricula);
		}
	}

	public void adicionaSeDiretoria(String placa) throws Exception {
		if (!FuncionarioDAO.getFuncDAO().getList().isEmpty()) {
			if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadePlaca(placa)) {
				for (Funcionario f : FuncionarioDAO.getFuncDAO().getList()) {
					if (verificaCargoDiretoria(f.getCargo()) && !f.getListaDeCarrosLiberados().contains(
							ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa))) {
						addPermVeic(f.getNumeroMatricula(), placa);
						FuncionarioDAO.getFuncDAO().persist();
						telaListaFunc.updateData();
						telaListVeicFunc.updateData(f.getNumeroMatricula());
					}
				}
			}
		} else {
			throw new ListaVaziaException("\nNao ha funcionarios cadastrados");
		}
	}

	public String pegaVeicAlugado(String numeroMatricula) {
		if (validadeMatricula(numeroMatricula)) {
			if (!ControladorPrincipal.getCtrlPrincipal().getCtrlEmprestimo().getEmpDAO().getList().isEmpty()) {
				for (Emprestimo e : ControladorPrincipal.getCtrlPrincipal().getCtrlEmprestimo().getEmpDAO().getList()) {
					if (e.getUsuario().getNumeroMatricula().equalsIgnoreCase(numeroMatricula)) {
						return e.getUtilitario().getPlaca();
					}
				}
			}
		}
		return null;
	}

	public Veiculo pegaPrimeiroVeiculo(String numeroMatricula) {

		return buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados().get(0);

	}

	// Add & Remove car permission method

	public void addPermVeic(String numeroMatricula, String placa) throws Exception {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa)) {
				if (!buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()
						.contains(ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa))) {
					buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()
							.add(ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa));
					FuncionarioDAO.getFuncDAO().persist();
					telaListaFunc.updateData();
					telaListVeicFunc.updateData(numeroMatricula);
				} else {
					throw new Exception("Funcionario ja possui esta permissao");
				}
			} else {
				throw new VeiculoException("Veiculo inexistente");
			}
		} else {
			throw new FuncionarioException("Funcionario inexistente");
		}
	}

	public void delPermVeic(String numeroMatricula, String placa) throws Exception {
		if (verificaFuncionarioExiste(numeroMatricula)) {
			if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().verificaVeiculoExiste(placa)) {
				if (buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()
						.contains(ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa))) {
					buscarPelaMatricula(numeroMatricula).getListaDeCarrosLiberados()
							.remove(ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa));
					FuncionarioDAO.getFuncDAO().persist();
					telaListaFunc.updateData();
					telaListVeicFunc.updateData(numeroMatricula);
				} else {
					throw new Exception("O funcionario nao possui esta permissao");
				}
			} else {
				throw new VeiculoException("Veiculo inexistente");
			}
		} else {
			throw new FuncionarioException("Funcionario inexistente");
		}
	}

	public void delPermVeicAll(String placa) throws Exception {
		if (ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().validadePlaca(placa)) {
			if (!FuncionarioDAO.getFuncDAO().getList().isEmpty()) {
				for (Funcionario f : FuncionarioDAO.getFuncDAO().getList()) {
					for (Veiculo v : f.getListaDeCarrosLiberados()) {
						if (v.getPlaca().equalsIgnoreCase(placa)) {
							f.getListaDeCarrosLiberados().remove(
									ControladorPrincipal.getCtrlPrincipal().getCtrlVeiculo().buscarPelaPlaca(placa));
							FuncionarioDAO.getFuncDAO().persist();
							telaListVeicFunc.updateData(f.getNumeroMatricula());
						}
					}
				}
				FuncionarioDAO.getFuncDAO().persist();
				telaListaFunc.updateData();
			} else {
				throw new ListaVaziaException("Nao existem funcionarios cadastrados");
			}
		} else {
			throw new IllegalArgumentException("Placa invalida");
		}
	}

	// Window method

	public void telaCadFunc() {
		telaCadFunc.setVisible(true);
	}

	public void telaListaFunc() {
		telaListaFunc.setVisible(true);
	}

	public void updateTelaListaFuncData() {
		telaListaFunc.updateData();
	}

	public void telaAlteraFunc() {
		telaAlteraFunc.setVisible(true);
	}

	public void telaExcluiFunc() {
		telaExcluiFunc.setVisible(true);
	}

	public void telaChamaList() {
		telaChamaList.setVisible(true);
	}

	public void telaListVeicFunc(String numMat) {
		telaListVeicFunc.init();
		telaListVeicFunc.updateData(numMat);
		telaListVeicFunc.setVisible(true);
	}

	public void telaAddVeicFunc() {
		telaAddVeicFunc.setVisible(true);
	}
	
	public void updateTelaListVeicFuncData(String numeroMatricula) {
		telaListVeicFunc.updateData(numeroMatricula);
	}

	// Getter & Setters

	public FuncionarioDAO getFuncDAO() {

		return FuncionarioDAO.getFuncDAO();

	}

	public static ControladorFuncionario getCtrlFuncionario() {
		if (ctrlFuncionario == null) {
			ctrlFuncionario = new ControladorFuncionario();
		}
		return ctrlFuncionario;
	}

	public static void setCtrlFuncionario(ControladorFuncionario ctrlFuncionario) {
		ControladorFuncionario.ctrlFuncionario = ctrlFuncionario;
	}

}