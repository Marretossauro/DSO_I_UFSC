package br.ufsc.ine5605.trab1.display;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class TelaListaVeic extends JFrame {

	private static final long serialVersionUID = 1783538359577299006L;
	private ControladorVeiculo ctrlVeic;

	// Components

	private String[] colunas = { "Placa", "Modelo", "Marca", "Ano", "Quilometragem", "Disponibilidade" };
	private JTable tabelaVeic;
	private DefaultTableModel tabelaV;

	public TelaListaVeic(ControladorVeiculo owner) {
		super("Tabela de Veiculos");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlVeic = owner;
		this.tabelaV = new DefaultTableModel(colunas, 0);
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

		tabelaVeic = new JTable();
		tabelaVeic.setModel(tabelaV);
		scrollPane.setViewportView(tabelaVeic);

		// JFrame configuration

		setSize(665, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void updateData() {
		tabelaV.setNumRows(0);
		for(Veiculo v : ctrlVeic.getVeicDAO().getList()) {
			String placa = v.getPlaca();
			String modelo = v.getModelo();
			String marca = v.getMarca();
			Integer ano = v.getAno();
			Integer quilometragemAtual = v.getQuilometragemAtual();
			boolean disponibilidade = v.isDisponivel();
			Object[] row = { placa, modelo, marca, ano, quilometragemAtual, disponibilidade };
			tabelaV.addRow(row);
		}
	}

}
