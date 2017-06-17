package br.ufsc.ine5605.trab1.display;

import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorLog;

public class TelaListaLog extends JFrame {

	private static final long serialVersionUID = -1146209161108623184L;
	private ControladorLog ctrlLog;
	
	// Components
	
	private String[] colunas = { "Motivo", "Matricula", "Placa", "Data" };
	private JTable tabelaLogs;
	private DefaultTableModel tabelaL;
	
	public TelaListaLog() {
		
	}

}
