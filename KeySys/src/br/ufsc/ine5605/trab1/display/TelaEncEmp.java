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

public class TelaEncEmp extends JFrame {

	private static final long serialVersionUID = -3449322804388054502L;
	private ControladorEmprestimo ctrlEmp;
	private GerenciadorBotoesEmp buttManager;

	// Components

	private JLabel lbMat;
	private JLabel lbQuil;
	private JLabel lbCod;
	private JTextField tfMat;
	private JTextField tfQuil;
	private JTextField tfCod;
	private JButton btOk;

	public TelaEncEmp(ControladorEmprestimo owner) {
		super("Encerrar emprestimo");
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

		// Code set

		lbCod = new JLabel();
		lbCod.setText("Codigo: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbCod, constraints);
		tfCod = new JTextField();
		tfCod.setText("");
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfCod.setPreferredSize(new Dimension(100, 20));
		container.add(tfCod, constraints);

		// Km set
		
		lbQuil = new JLabel();
		lbQuil.setText("Quilometragem: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(lbQuil, constraints);
		tfQuil = new JTextField();
		tfQuil.setText("");
		constraints.gridx = 1;
		constraints.gridy = 2;
		tfQuil.setPreferredSize(new Dimension(100, 20));
		container.add(tfQuil, constraints);
		
		// Ok button set

		btOk = new JButton();
		btOk.setText("Remover!");
		btOk.setActionCommand("Remove");
		btOk.addActionListener(buttManager);
		constraints.gridx = 1;
		constraints.gridy = 3;
		container.add(btOk, constraints);

		// JFrame configuration

		setSize(550, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesEmp implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Remove")) {
				try {
					ctrlEmp.verificaEmp(Integer.parseInt(tfQuil.getText()), tfMat.getText(), Integer.parseInt(tfCod.getText()));
					JOptionPane.showMessageDialog(null, "Emprestimo encerrado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		}

	}

}
