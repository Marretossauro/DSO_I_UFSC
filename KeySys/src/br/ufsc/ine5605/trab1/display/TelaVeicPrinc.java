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
import javax.swing.UnsupportedLookAndFeelException;

import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;

public class TelaVeicPrinc extends JFrame {

	private static final long serialVersionUID = -2423257282527255526L;
	private GerenciadorBotoesVeicPrinc buttManager;
	private ControladorVeiculo ctrlVeic;

	// Complements

	private JButton btCadastrar;
	private JButton btAlterar;
	private JButton btExcluir;
	private JButton btListar;

	public TelaVeicPrinc(ControladorVeiculo owner) {
		super("Sistema de Veiculos");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlVeic = owner;
		this.buttManager = new GerenciadorBotoesVeicPrinc();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Register button

		btCadastrar = new JButton();
		btCadastrar.setText("Cadastrar Veiculo");
		btCadastrar.setActionCommand("CadastraVeiculo");
		btCadastrar.addActionListener(buttManager);
		btCadastrar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(btCadastrar, constraints);

		// Update button

		btAlterar = new JButton();
		btAlterar.setText("Alterar Veiculo");
		btAlterar.setActionCommand("AlteraVeiculo");
		btAlterar.addActionListener(buttManager);
		btAlterar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(btAlterar, constraints);

		// Delete button

		btExcluir = new JButton();
		btExcluir.setText("Excluir Veiculo");
		btExcluir.setActionCommand("ExcluiVeiculo");
		btExcluir.addActionListener(buttManager);
		btExcluir.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(btExcluir, constraints);

		// List button

		btListar = new JButton();
		btListar.setText("Listar Veiculos");
		btListar.setActionCommand("ListaVeiculos");
		btListar.addActionListener(buttManager);
		btListar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(btListar, constraints);

		// JFrame configuration

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesVeicPrinc implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("CadastraVeiculo")) {
				ctrlVeic.telaCadVeic();
			} else if (e.getActionCommand().equals("AlteraVeiculo")) {
				ctrlVeic.telaAlteraVeic();
			}
		}

	}

}
