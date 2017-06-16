package br.ufsc.ine5605.trab1.display;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;

import br.ufsc.ine5605.trab1.controllers.ControladorEmprestimo;
import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;

public class TelaRealEmp extends JFrame {

	private static final long serialVersionUID = 6697069927777431316L;
	private ControladorEmprestimo ctrlEmp;
	private GerenciadorBotoesEmp buttManager;

	// Components

	private JLabel lbMat;
	private JLabel lbPlac;
	private JTextField tfMat;
	private JTextField tfPlac;
	private JButton btOk;

	public TelaRealEmp(ControladorEmprestimo owner) {
		super("Realiza Emprestimo");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlEmp = owner;
		this.buttManager = new GerenciadorBotoesEmp();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Registration set

		lbMat = new JLabel();
		lbMat.setText("Matricula: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbMat, constraints);
		tfMat = new JTextField();
		tfMat.setText("");
		constraints.gridx = 1;
		constraints.gridy = 0;
		tfMat.setPreferredSize(new Dimension(100, 20));
		container.add(tfMat, constraints);

		// Car plate set

		lbPlac = new JLabel();
		lbPlac.setText("Placa: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbPlac, constraints);
		tfPlac = new JTextField();
		tfPlac.setText("");
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfPlac.setPreferredSize(new Dimension(100, 20));
		container.add(tfPlac, constraints);

		// Ok button set

		btOk = new JButton();
		btOk.setText("Emprestar!");
		btOk.setActionCommand("Empresta");
		btOk.addActionListener(buttManager);
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(btOk, constraints);

		// JFrame configuration

		setSize(550, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesEmp implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Empresta")) {
				try {
					ctrlEmp.adicionaEmprestimo(tfMat.getText(), tfPlac.getText());
					JOptionPane.showMessageDialog(null, "Emprestimo realizado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}

	}

}
