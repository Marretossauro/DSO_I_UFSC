package br.ufsc.ine5605.trab1.display;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorLog;
import br.ufsc.ine5605.trab1.objects.Log;

public class TelaListaLogByMot extends JFrame {
	
	private static final long serialVersionUID = -6727074098724891667L;
	private ControladorLog ctrlLog;

	// Components

	private String[] colunas = { "Motivo", "Matricula", "Placa", "Data" };
	private JTable tabelaLogs;
	private DefaultTableModel tabelaL;

	public TelaListaLogByMot(ControladorLog owner) {
		super("Tabela de Logs por Motivo");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlLog = owner;
		this.tabelaL = new DefaultTableModel(colunas, 0);
		init();
	}

	public void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());

		// Table

		container.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 635, 365);
		container.add(scrollPane);

		tabelaLogs = new JTable();
		tabelaLogs.setModel(tabelaL);
		scrollPane.setViewportView(tabelaLogs);

		// JFrame configuration

		setSize(665, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void updateData(String motivolog) {
		tabelaL.setNumRows(0);
		try {
			for (Log l : ctrlLog.buscaLogsByMotivo(motivolog)) {
				String motivo = l.getMotivo();
				String mat = l.getNumeroMatricula();
				String placa = l.getPlaca();
				String data = l.getDataDoLog();
				Object[] row = { motivo, mat, placa, data };
				tabelaL.addRow(row);
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
	}

}
