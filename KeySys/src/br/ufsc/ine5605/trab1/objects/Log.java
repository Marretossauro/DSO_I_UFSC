package br.ufsc.ine5605.trab1.objects;

public class Log {

	private String motivo;
	private String numeroMatricula;
	private String placa;
	private String dataDoLog;

	// Constructor

	public Log(String motivo, String numeroMatricula, String placa, String dataDoLog) {
		super();
		this.motivo = motivo;
		this.numeroMatricula = numeroMatricula;
		this.placa = placa;
		this.dataDoLog = dataDoLog;
	}

	// Getters & Setters

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public String getNumeroMatricula() {
		return numeroMatricula;
	}

	public void setNumeroMatricula(String numeroMatricula) {
		this.numeroMatricula = numeroMatricula;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getDataDoLog() {
		return dataDoLog;
	}

	public void setDataDoLog(String dataDoLog) {
		this.dataDoLog = dataDoLog;
	}

}
