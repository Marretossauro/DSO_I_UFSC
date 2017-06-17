package br.ufsc.ine5605.trab1.display;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorEmprestimo;
import br.ufsc.ine5605.trab1.objects.Emprestimo;

public class TelaListaEmp extends JFrame {

	private static final long serialVersionUID = -7017718268147991064L;
	private ControladorEmprestimo ctrlEmp;

	// Components

	private String[] colunas = { "Codigo", "Matricula", "Placa" };
	private JTable tabelaEmprestimos;
	private DefaultTableModel tabelaE;

	public TelaListaEmp(ControladorEmprestimo owner) {
		super("Listar Emprestimos");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlEmp = owner;
		this.tabelaE = new DefaultTableModel(colunas, 0);
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());

		// Table

		updateData();
		
		container.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 635, 365);
		container.add(scrollPane);

		tabelaEmprestimos = new JTable();
		tabelaEmprestimos.setModel(tabelaE);
		scrollPane.setViewportView(tabelaEmprestimos);

		// JFrame configuration

		setSize(665, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void updateData() {
		tabelaE.setNumRows(0);
		for (Emprestimo e : ctrlEmp.getEmpDAO().getList()) {
			String codigo = Integer.toString(e.getCodigo());
			String mat = e.getUsuario().getNumeroMatricula();
			String placa = e.getUtilitario().getPlaca();
			Object[] row = { codigo, mat, placa };
			tabelaE.addRow(row);
		}
	}

}
