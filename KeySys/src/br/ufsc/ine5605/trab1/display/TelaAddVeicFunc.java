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
import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;

public class TelaAddVeicFunc extends JFrame {

	private static final long serialVersionUID = -1236542485250718979L;
	private ControladorPrincipal ctrlPrinc;
	private GerenciadorBotoesAddV buttManager;

	// Components

	private JLabel lbMat;
	private JLabel lbPlac;
	private JTextField tfMat;
	private JTextField tfPlac;
	private JButton btAdd;
	private JButton btDel;

	public TelaAddVeicFunc(ControladorPrincipal owner) {
		super("Alterar veiculos permitidos");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlPrinc = owner;
		this.buttManager = new GerenciadorBotoesAddV();
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

		// Add button set

		btAdd = new JButton();
		btAdd.setActionCommand("Incluir");
		btAdd.addActionListener(buttManager);
		btAdd.setText("Adicionar!");
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(btAdd, constraints);

		// Remove button set

		btDel = new JButton();
		btDel.setActionCommand("Deletar");
		btDel.addActionListener(buttManager);
		btDel.setText("Excluir!");
		constraints.gridx = 1;
		constraints.gridy = 3;
		container.add(btDel, constraints);

		// JFrame configuration

		setSize(350, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesAddV implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Incluir")) {
				try {
					ctrlPrinc.getCtrlFuncionario().addPermVeic(
							ctrlPrinc.getCtrlFuncionario().buscarPelaMatricula(tfMat.getText()),
							ctrlPrinc.getCtrlVeiculo().buscarPelaPlaca(tfPlac.getText()));
					JOptionPane.showMessageDialog(null, "Adicionado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					setVisible(false);
					dispose();
				}
			} else if (e.getActionCommand().equals("Deletar")) {
				try {
					ctrlPrinc.getCtrlFuncionario().delPermVeic(
							ctrlPrinc.getCtrlFuncionario().buscarPelaMatricula(tfMat.getText()),
							ctrlPrinc.getCtrlVeiculo().buscarPelaPlaca(tfPlac.getText()));
					JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					setVisible(false);
					dispose();
				}
			}
		}

	}

}
