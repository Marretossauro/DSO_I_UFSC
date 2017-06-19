package br.ufsc.ine5605.trab1.display;


import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;

public class TelaFuncPrinc extends JFrame {

	private static final long serialVersionUID = 1514075721089302291L;
	private GerenciadorBotoesFuncGeral buttManager;
	private ControladorFuncionario ctrlFuncionario;

	// Components

	private JButton btCadastrar;
	private JButton btAlterar;
	private JButton btExcluir;
	private JButton btListar;
	private JButton btListVeicPerm;
	private JButton btAddVeicPerm;

	public TelaFuncPrinc(ControladorFuncionario owner) {
		super("Sistema de Funcionarios");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlFuncionario = owner;
		this.buttManager = new GerenciadorBotoesFuncGeral();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Register button

		btCadastrar = new JButton();
		btCadastrar.setText("Cadastrar Funcionario");
		btCadastrar.setActionCommand("CadastraFuncionario");
		btCadastrar.addActionListener(buttManager);
		btCadastrar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(btCadastrar, constraints);

		// Update button

		btAlterar = new JButton();
		btAlterar.setText("Alterar Funcionario");
		btAlterar.setActionCommand("AlteraFuncionario");
		btAlterar.addActionListener(buttManager);
		btAlterar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(btAlterar, constraints);

		// Delete button

		btExcluir = new JButton();
		btExcluir.setText("Excluir Funcionario");
		btExcluir.setActionCommand("ExcluiFuncionario");
		btExcluir.addActionListener(buttManager);
		btExcluir.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(btExcluir, constraints);

		// List button

		btListar = new JButton();
		btListar.setText("Listar Funcionarios");
		btListar.setActionCommand("ListaFuncionarios");
		btListar.addActionListener(buttManager);
		btListar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(btListar, constraints);

		// List permitted cars button

		btListVeicPerm = new JButton();
		btListVeicPerm.setText("Listar Veiculos Permitidos por Funcionario");
		btListVeicPerm.setActionCommand("ListaVeicFuncionarios");
		btListVeicPerm.addActionListener(buttManager);
		btListVeicPerm.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(btListVeicPerm, constraints);

		//

		btAddVeicPerm = new JButton();
		btAddVeicPerm.setText("Alterar permissoes de veiculos dos funcionarios");
		btAddVeicPerm.setActionCommand("AddVeicPermFunc");
		btAddVeicPerm.addActionListener(buttManager);
		btAddVeicPerm.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 5;
		container.add(btAddVeicPerm, constraints);

		// JFrame Configuration

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesFuncGeral implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("CadastraFuncionario")) {
				ctrlFuncionario.telaCadFunc();
			} else if (e.getActionCommand().equals("ListaFuncionarios")) {
				ctrlFuncionario.telaListaFunc();
			} else if (e.getActionCommand().equals("AlteraFuncionario")) {
				ctrlFuncionario.telaAlteraFunc();
			} else if (e.getActionCommand().equals("ExcluiFuncionario")) {
				ctrlFuncionario.telaExcluiFunc();
			} else if (e.getActionCommand().equals("ListaVeicFuncionarios")) {
				ctrlFuncionario.telaChamaList();
			} else if (e.getActionCommand().equals("AddVeicPermFunc")) {
				ctrlFuncionario.telaAddVeicFunc();
			}
		}

	}

}
