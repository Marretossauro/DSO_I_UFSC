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

import br.ufsc.ine5605.trab1.controllers.ControladorEmprestimo;

public class TelaEmpPrinc extends JFrame {

	private static final long serialVersionUID = -8512741658253693379L;
	private GeradorBotoesEmpPrinc buttManager;
	private ControladorEmprestimo ctrlEmp;

	// Components

	private JButton btEmprestimo;
	private JButton btDevolver;
	private JButton btListar;

	public TelaEmpPrinc(ControladorEmprestimo owner) {
		super("Sistema de Emprestimos");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlEmp = owner;
		this.buttManager = new GeradorBotoesEmpPrinc();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Rent button

		btEmprestimo = new JButton();
		btEmprestimo.setActionCommand("Empresta");
		btEmprestimo.setText("Realiza Emprestimo");
		btEmprestimo.addActionListener(buttManager);
		btEmprestimo.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(btEmprestimo, constraints);

		// Return car button

		btDevolver = new JButton();
		btDevolver.setActionCommand("Devolve");
		btDevolver.setText("Devolve veiculo");
		btDevolver.addActionListener(buttManager);
		btDevolver.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(btDevolver, constraints);

		// List rents button

		btListar = new JButton();
		btListar.setActionCommand("Lista");
		btListar.setText("Lista Emprestimos");
		btListar.addActionListener(buttManager);
		btListar.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(btListar, constraints);

		// JFrame configuration

		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GeradorBotoesEmpPrinc implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Empresta")) {
				ctrlEmp.telaRE();
			} else if (e.getActionCommand().equals("Devolve")) {
				ctrlEmp.telaEncEmp();
			} else if (e.getActionCommand().equals("Lista")) {
				ctrlEmp.telaListaEmp();
			}
		}

	}

}
