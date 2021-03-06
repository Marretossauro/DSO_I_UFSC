package br.ufsc.ine5605.trab1.controllers;

import java.util.ArrayList;

import br.ufsc.ine5605.trab1.display.TelaAlterarVeic;
import br.ufsc.ine5605.trab1.display.TelaCadastroVeic;
import br.ufsc.ine5605.trab1.display.TelaExcluirVeic;
import br.ufsc.ine5605.trab1.display.TelaListaVeic;
import br.ufsc.ine5605.trab1.display.TelaVeicPrinc;
//import br.ufsc.ine5605.trab1.display.TelaVeiculo;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
import br.ufsc.ine5605.trab1.exceptions.VeiculoException;
import br.ufsc.ine5605.trab1.interfaces.IRucd;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.Veiculo;
import br.ufsc.ine5605.trab1.persistencia.VeiculoDAO;

public class ControladorVeiculo extends Controlador implements IRucd {

	private TelaVeicPrinc telaVeicPrinc;
	private TelaCadastroVeic telaCadVeic;
	private TelaAlterarVeic telaAlteraVeic;
	private TelaListaVeic telaListaVeic;
	private TelaExcluirVeic telaExcluiVeic;
	private static ControladorVeiculo ctrlVeiculo;

	// Constructor

	public ControladorVeiculo() {
		super();
		telaVeicPrinc = new TelaVeicPrinc(this);
		telaCadVeic = new TelaCadastroVeic(this);
		telaAlteraVeic = new TelaAlterarVeic(this);
		telaListaVeic = new TelaListaVeic(this);
		telaExcluiVeic = new TelaExcluirVeic(this);
	}

	// Override methods

	@Override
	public void inicia() {
		telaVeicPrinc.setVisible(true);
	}

	@Override
	public void cadastrar(Object veiculo) throws IllegalArgumentException {
		Veiculo veic = (Veiculo) veiculo;
		if (veic.getAno() != 0 && !veic.getMarca().equals("") && !veic.getModelo().equals("")
				&& !veic.getPlaca().equals("") && veic != null) {
			if (!VeiculoDAO.getVeicDAO().getList().isEmpty()) {
				if (!verificaVeiculoExiste(veic.getPlaca())) {
					VeiculoDAO.getVeicDAO().put(veic);
					telaListaVeic.updateData();
				} else {
					throw new IllegalArgumentException("Veiculo existente");
				}
			} else {
				VeiculoDAO.getVeicDAO().put(veic);
				telaListaVeic.updateData();
			}
		} else {
			throw new IllegalArgumentException("Veiculo nulo");
		}
	}

	@Override
	public void excluir(String placa) throws Exception {
		if (verificaVeiculoExiste(placa)) {
			for (Funcionario f : ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().getFuncDAO().getList()) {
				if (!ControladorPrincipal.getCtrlPrincipal().getCtrlEmprestimo()
						.verificaEmprestimoMatriculaPlaca(f.getNumeroMatricula(), placa)) {
					VeiculoDAO.getVeicDAO().remove(placa);
					telaListaVeic.updateData();
				} else {
					throw new Exception("Este veiculo esta emprestado, devolva antes de excluir");
				}
			}
		} else {
			throw new VeiculoException("\nVeiculo inexistente");
		}
	}

	// Update method

	public void alterar(String placa, String modelo, String marca, int ano, int quilometragemAtual) throws Exception {
		if (VeiculoDAO.getVeicDAO().get(placa) != null) {
			if (!VeiculoDAO.getVeicDAO().getList().isEmpty()) {
				VeiculoDAO.getVeicDAO().get(placa).setModelo(modelo);
				VeiculoDAO.getVeicDAO().get(placa).setMarca(marca);
				VeiculoDAO.getVeicDAO().get(placa).setAno(ano);
				VeiculoDAO.getVeicDAO().get(placa).setQuilometragemAtual(quilometragemAtual);
				VeiculoDAO.getVeicDAO().persist();
				telaListaVeic.updateData();
				ControladorPrincipal.getCtrlPrincipal().getCtrlFuncionario().alteraPermVeicAll(placa);
			} else {
				throw new ListaVaziaException("\nNao ha veiculos cadastrados");
			}
		} else {
			throw new IllegalArgumentException("\nVeiculo nulo");
		}
	}

	// Receives data method

	public void recebeDados(String placa, String modelo, String marca, int ano, int quilometragemAtual)
			throws IllegalArgumentException {
		Veiculo veic = new Veiculo(placa, modelo, marca, ano, quilometragemAtual);
		cadastrar(veic);
	}

	// List and Exhibit methods

	public ArrayList<Veiculo> listarVeiculos() {
		return new ArrayList<Veiculo>(VeiculoDAO.getVeicDAO().getList());
	}

	// Verifications

	public boolean validadePlaca(String placa) {
		boolean validade = false;

		if (placa.matches("[a-zA-Z]{3,3}-\\d{4,4}") && !placa.substring(4, placa.length()).equalsIgnoreCase("0000")) {
			validade = true;
		}

		return validade;
	}

	public boolean verificaVeiculoExiste(String placa) {
		if (!VeiculoDAO.getVeicDAO().getList().isEmpty()) {
			for (int i = 0; i < listarVeiculos().size(); i++) {
				if (listarVeiculos().get(i).getPlaca().equalsIgnoreCase(placa)) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean verificaModeloEMarca(String mm) {
		boolean validade = false;
		if (mm.length() >= 3) {
			for (int i = 0; i < mm.length(); i++) {
				if (Character.isAlphabetic(mm.charAt(i)) || Character.isDigit(mm.charAt(i))
						|| Character.isWhitespace(mm.charAt(i))) {
					validade = true;
				} else {
					return false;
				}
			}
		}
		return validade;
	}

	public boolean validadeAno(String ano) {
		boolean validade = false;
		for (int i = 0; i < ano.length(); i++) {
			if (Character.isDigit(ano.charAt(i))) {
				if (Integer.valueOf(Integer.parseInt(ano)) > 1909 && Integer.valueOf(Integer.parseInt(ano)) < 2018) {
					validade = true;
				}
			} else {
				return false;
			}
		}
		return validade;
	}

	public boolean validadeKm(String quilometragemAtual) {
		boolean validade = false;
		for (int i = 0; i < quilometragemAtual.length(); i++) {
			if (Character.isDigit(quilometragemAtual.charAt(i))) {
				if (Integer.valueOf(Integer.parseInt(quilometragemAtual)) > 0
						&& Integer.valueOf(Integer.parseInt(quilometragemAtual)) <= 500000) {
					validade = true;
				}
			} else {
				return false;
			}
		}
		return validade;
	}

	// Search method

	public Veiculo buscarPelaPlaca(String placa) {
		if (verificaVeiculoExiste(placa)) {
			for (Veiculo v : VeiculoDAO.getVeicDAO().getList()) {
				if (v.getPlaca().equalsIgnoreCase(placa)) {
					return v;
				}
			}
		}
		return null;
	}

	// Window method

	public void telaCadVeic() {
		telaCadVeic.setVisible(true);
	}

	public void telaAlteraVeic() {
		telaAlteraVeic.setVisible(true);
	}

	public void telaListaVeic() {
		telaListaVeic.setVisible(true);
	}

	public void updateTelaListaVeicData() {
		telaListaVeic.updateData();
	}

	public void telaExcluiVeic() {
		telaExcluiVeic.setVisible(true);
	}

	// Getters & Setters

	public static ControladorVeiculo getCtrlVeiculo() {
		if (ctrlVeiculo == null) {
			ctrlVeiculo = new ControladorVeiculo();
		}
		return ctrlVeiculo;
	}

	public static void setCtrlVeiculo(ControladorVeiculo ctrlVeiculo) {
		ControladorVeiculo.ctrlVeiculo = ctrlVeiculo;
	}

	public VeiculoDAO getVeicDAO() {

		return VeiculoDAO.getVeicDAO();

	}

}
