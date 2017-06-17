package br.ufsc.ine5605.trab1.display;

import java.awt.Container;

import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.objects.Veiculo;

public class TelaListaVeicFunc extends JFrame {

	private static final long serialVersionUID = 8449556443344085899L;
	private ControladorFuncionario ctrlFunc;
	
	// Components
	
	private String[] colunas = { "Placa", "Modelo", "Marca", "Ano", "Quilometragem", "Disponibilidade" };
	private JTable tabelaVeicFunc;
	private DefaultTableModel tabelaVF;

	public TelaListaVeicFunc(ControladorFuncionario owner) {
		super("Tabela de Veiculos por Funcionario");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlFunc = owner;
		this.tabelaVF = new DefaultTableModel(colunas, 0);
	}
	
	public void init() {
		
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());

		// Table
		
		container.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 12, 635, 365);
		container.add(scrollPane);

		tabelaVeicFunc = new JTable();
		tabelaVeicFunc.setModel(tabelaVF);
		scrollPane.setViewportView(tabelaVeicFunc);

		// JFrame configuration

		setSize(665, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	public void updateData(String numMat) {
		tabelaVF.setNumRows(0);
		if(numMat != null) {
			for(Veiculo v : ctrlFunc.buscarPelaMatricula(numMat).getListaDeCarrosLiberados()) {
				String placa = v.getPlaca();
				String modelo = v.getModelo();
				String marca = v.getMarca();
				Integer ano = v.getAno();
				Integer quilometragemAtual = v.getQuilometragemAtual();
				boolean disponibilidade = v.isDisponivel();
				Object[] row = { placa, modelo, marca, ano, quilometragemAtual, disponibilidade };
				tabelaVF.addRow(row);
				setVisible(true);
			}
		} else {
			JOptionPane.showMessageDialog(null, "Funcionario inexistente ou nao possui veiculos disponiveis");
			setVisible(false);
			dispose();
		}
		
	}

}
