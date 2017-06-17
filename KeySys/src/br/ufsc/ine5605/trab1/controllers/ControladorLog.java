package br.ufsc.ine5605.trab1.controllers;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Date;

import br.ufsc.ine5605.trab1.display.TelaChamaLogByMat;
import br.ufsc.ine5605.trab1.display.TelaChamaLogByMot;
import br.ufsc.ine5605.trab1.display.TelaChamaLogByPlac;
import br.ufsc.ine5605.trab1.display.TelaListaLog;
import br.ufsc.ine5605.trab1.display.TelaListaLogByMat;
import br.ufsc.ine5605.trab1.display.TelaListaLogByMot;
import br.ufsc.ine5605.trab1.display.TelaListaLogByPlaca;
import br.ufsc.ine5605.trab1.display.TelaLogPrinc;
import br.ufsc.ine5605.trab1.exceptions.ListaVaziaException;
import br.ufsc.ine5605.trab1.objects.Log;
import br.ufsc.ine5605.trab1.persistencia.LogDAO;

public class ControladorLog extends Controlador {

	// private ArrayList<Log> listaLogs;
	private static ControladorLog ctrlLog;
	// private TelaLog telaLog;
	private TelaLogPrinc telaLogPrinc;
	private TelaListaLog telaListLog;
	private TelaChamaLogByMot telaChama;
	private TelaChamaLogByMat telaChamaMat;
	private TelaChamaLogByPlac telaChamaPlaca;
	private TelaListaLogByMat telaListaLogMat;
	private TelaListaLogByMot telaListaLogMot;
	private TelaListaLogByPlaca telaListaLogPlaca;

	// Constructor

	public ControladorLog() {
		super();
		// this.listaLogs = new ArrayList<>();
		// this.telaLog = new TelaLog(this);
		this.telaLogPrinc = new TelaLogPrinc(this);
		this.telaListLog = new TelaListaLog(this);
		this.telaChama = new TelaChamaLogByMot(this);
		this.telaChamaMat = new TelaChamaLogByMat(this);
		this.telaChamaPlaca = new TelaChamaLogByPlac(this);
		this.telaListaLogMat = new TelaListaLogByMat(this);
		this.telaListaLogMot = new TelaListaLogByMot(this);
		this.telaListaLogPlaca = new TelaListaLogByPlaca(this);
	}

	// Override method

	@Override
	public void inicia() {
		// telaLog.exibeMenuInicial();
		telaLogPrinc.setVisible(true);
	}

	// Create method

	public void criaLog(String motivo, String numeroMatricula, String placa) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy - hh:mm:ss");
		String dataLog = "";

		dataLog = sdf.format(new Date());

		Log log = new Log(motivo, numeroMatricula, placa, dataLog);
		LogDAO.getlogDAO().put(log);
	}

	// Search methods

	public ArrayList<Log> buscaLogsByMotivo(String motivo) throws Exception {

		ArrayList<Log> listaLogsByMotivo = new ArrayList<>();

		if (motivo != null) {
			if (!LogDAO.getlogDAO().getList().isEmpty()) {
				for (Log l : LogDAO.getlogDAO().getList()) {
					if (l.getMotivo().toLowerCase().contains(motivo.toLowerCase())) {
						listaLogsByMotivo.add(l);
					}
				}
			} else {
				throw new ListaVaziaException("\nNenhum registro foi gerado");
			}
		} else {
			throw new IllegalArgumentException("\nMotivo nulo");
		}
		return listaLogsByMotivo;
	}

	public ArrayList<Log> buscaLogsByMatricula(String numeroMatricula) throws Exception {

		ArrayList<Log> listaLogsByNumMat = new ArrayList<>();

		if (ControladorFuncionario.getCtrlFuncionario().validadeMatricula(numeroMatricula)
				&& ControladorFuncionario.getCtrlFuncionario().verificaFuncionarioExiste(numeroMatricula)) {
			if (!LogDAO.getlogDAO().getList().isEmpty()) {
				for (Log l : LogDAO.getlogDAO().getList()) {
					if (l.getNumeroMatricula().equalsIgnoreCase(numeroMatricula)) {
						listaLogsByNumMat.add(l);
					}
				}
			} else {
				throw new ListaVaziaException("\nNenhum registro foi gerado");
			}
		} else {
			throw new IllegalArgumentException("Funcionario inexistente");
		}
		return listaLogsByNumMat;
	}

	public ArrayList<Log> buscaLogsByPlaca(String placa) throws Exception {

		ArrayList<Log> listaLogsByPlaca = new ArrayList<>();

		if (ControladorVeiculo.getCtrlVeiculo().validadePlaca(placa)
				&& ControladorVeiculo.getCtrlVeiculo().verificaVeiculoExiste(placa)) {
			if (!LogDAO.getlogDAO().getList().isEmpty()) {
				for (Log l : LogDAO.getlogDAO().getList()) {
					if (l.getPlaca().equalsIgnoreCase(placa)) {
						listaLogsByPlaca.add(l);
					}
				}
			} else {
				throw new ListaVaziaException("\nNenhum registro foi gerado");
			}
		} else {
			throw new IllegalArgumentException("Veiculo inexistente");
		}
		return listaLogsByPlaca;
	}

	// Exhibit methods

	public String exibeListaLogs(ArrayList<Log> listaLogs) throws ListaVaziaException {
		String listaDeLog = "";
		if (!listaLogs.isEmpty()) {
			for (Log l : listaLogs) {
				listaDeLog += ("\nMotivo: " + l.getMotivo() + "\nNumero de Matricula: " + l.getNumeroMatricula()
						+ "\nPlaca do Veiculo: " + l.getPlaca() + "\nData e Hora do Registro: " + l.getDataDoLog()
						+ "\n");
			}
		} else {
			throw new ListaVaziaException("\nNenhum registro foi gerado");
		}
		return listaDeLog;
	}

	public String exibeListaLogsGeral() throws ListaVaziaException {
		String listaDeLog = "";
		if (!LogDAO.getlogDAO().getList().isEmpty()) {
			for (Log l : LogDAO.getlogDAO().getList()) {
				listaDeLog += ("\nMotivo: " + l.getMotivo() + "\nNumero de Matricula: " + l.getNumeroMatricula()
						+ "\nPlaca do Veiculo: " + l.getPlaca() + "\nData e Hora do Registro: " + l.getDataDoLog()
						+ "\n");
			}
		} else {
			throw new ListaVaziaException("\nNenhum registro foi gerado");
		}
		return listaDeLog;
	}

	// Window method

	public void telaListaLog() {
		telaListLog.setVisible(true);
	}

	public void updateTelaListaLogData() {
		telaListLog.updateData();
	}

	public void telaChamaListaLogMot() {
		telaChama.setVisible(true);
	}
	
	public void telaChamaListaMat() {
		telaChamaMat.setVisible(true);
	}
	
	public void telaChamaListaPlaca() {
		telaChamaPlaca.setVisible(true);
	}
	
	public void telaListaLogMot(String motivoLog) {
		telaListaLogMot.init();
		telaListaLogMot.updateData(motivoLog);
	}
	
	public void telaListaLogMat(String numeroMatricula) {
		telaListaLogMat.init();
		telaListaLogMat.updateData(numeroMatricula);
	}

	public void telaListaLogPlaca(String placa) {
		telaListaLogPlaca.init();
		telaListaLogPlaca.updateData(placa);
	}
	
	// Getters & Setters

	public static ControladorLog getCtrlLog() {
		if (ctrlLog == null) {
			ctrlLog = new ControladorLog();
		}
		return ctrlLog;
	}

	public static void setCtrlLog(ControladorLog ctrlLog) {
		ControladorLog.ctrlLog = ctrlLog;
	}

	public ArrayList<Log> getListaLogs() {
		return new ArrayList<Log>(LogDAO.getlogDAO().getList());
	}

	public LogDAO getLogDAO() {
		return LogDAO.getlogDAO();
	}

}
