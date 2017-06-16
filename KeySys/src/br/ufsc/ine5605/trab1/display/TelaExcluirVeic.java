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

public class TelaExcluirVeic extends JFrame {

	private static final long serialVersionUID = -4367431119836487474L;
	private ControladorPrincipal ctrlPrinc;
	private GerenciadorBotoesExVeic buttManager;

	// Components

	private JLabel lbPlac;
	private JTextField tfPlac;
	private JButton btOk;

	public TelaExcluirVeic(ControladorPrincipal owner) {
		super("Excluir veiculo");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlPrinc = owner;
		this.buttManager = new GerenciadorBotoesExVeic();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Car plate set

		lbPlac = new JLabel();
		lbPlac.setText("Placa: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbPlac, constraints);
		tfPlac = new JTextField();
		tfPlac.setText("");
		constraints.gridx = 1;
		constraints.gridy = 0;
		tfPlac.setPreferredSize(new Dimension(100, 20));
		container.add(tfPlac, constraints);

		// Ok button set

		btOk = new JButton();
		btOk.setText("Excluir!");
		btOk.addActionListener(buttManager);
		btOk.setActionCommand("Deletar");
		constraints.gridx = 1;
		constraints.gridy = 1;
		container.add(btOk, constraints);

		// JFrame configuration

		setSize(350, 150);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesExVeic implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Deletar")) {
				try {
					ctrlPrinc.getCtrlFuncionario().removeVeiculoDosFuncionarios(tfPlac.getText());
					ctrlPrinc.getCtrlVeiculo().excluir(tfPlac.getText());
					JOptionPane.showMessageDialog(null, "Veiculo excluido com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					setVisible(false);
					dispose();
				}
			}
		}

	}

}
