package br.ufsc.ine5605.trab1.display;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.table.DefaultTableModel;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.objects.Funcionario;
import br.ufsc.ine5605.trab1.objects.TipoCargo;

public class TelaListaFunc extends JFrame {

	private static final long serialVersionUID = 1119788470592187679L;
	private ControladorFuncionario ctrlFunc;

	// Components

	private String[] colunas = { "Matricula", "Nome", "Data de nascimento", "Telefone", "Tentativas de acesso",
			"Carro Alugado", "Cargo" };
	private JTable tabelaFuncionarios;
	private DefaultTableModel tabelaF;

	public TelaListaFunc(ControladorFuncionario owner) {
		super("Listar Funcionarios");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlFunc = owner;
		this.tabelaF = new DefaultTableModel(colunas, 0);
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

		tabelaFuncionarios = new JTable();
		tabelaFuncionarios.setModel(tabelaF);
		scrollPane.setViewportView(tabelaFuncionarios);

		// JFrame configuration

		setSize(665, 420);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	public void updateData() {
		tabelaF.setNumRows(0);
		for (Funcionario f : ctrlFunc.getFuncDAO().getList()) {
			String matricula = f.getNumeroMatricula();
			String nome = f.getNome();
			String dataNascimento = f.getDataNascimento();
			String telefone = f.getTelefone();
			String tentativaAcesso = Integer.toString(f.getTentativas());
			TipoCargo cargo = f.getCargo();
			String carroAlugado = "Sem carro";
			if (ctrlFunc.pegaVeicAlugado(f.getNumeroMatricula()) != null) {
				carroAlugado = ctrlFunc.pegaVeicAlugado(f.getNumeroMatricula()).getPlaca();
			}
			Object[] row = { matricula, nome, dataNascimento, telefone, tentativaAcesso, carroAlugado, cargo };
			tabelaF.addRow(row);
		}
	}

}