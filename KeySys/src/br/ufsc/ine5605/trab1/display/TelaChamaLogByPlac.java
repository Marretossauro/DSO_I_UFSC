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

import br.ufsc.ine5605.trab1.controllers.ControladorLog;

public class TelaChamaLogByPlac extends JFrame {

	private static final long serialVersionUID = -2413772967281689673L;
	private ControladorLog ctrlLog;
	private GerenciadorBotoesChama buttManager;
	
	// Components
	
	private JLabel lbPlaca;
	private JTextField tfPlaca;
	private JButton btOk;
	
	public TelaChamaLogByPlac(ControladorLog owner) {
		super("Listar Registros por Placa");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlLog = owner;
		this.buttManager = new GerenciadorBotoesChama();
		init();
	}
	
	private void init() {
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Motive set

		lbPlaca = new JLabel();
		lbPlaca.setText("Placa: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbPlaca, constraints);
		tfPlaca = new JTextField();
		tfPlaca.setText("");
		constraints.gridx = 1;
		constraints.gridy = 0;
		tfPlaca.setPreferredSize(new Dimension(100, 20));
		container.add(tfPlaca, constraints);
		
		// Ok Button

		btOk = new JButton();
		btOk.setActionCommand("ListarLP");
		btOk.addActionListener(buttManager);
		btOk.setText("Listar!");
		constraints.gridx = 1;
		constraints.gridy = 5;
		container.add(btOk, constraints);

		// JFrame configuration

		setSize(300, 300);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private class GerenciadorBotoesChama implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("ListarLP")) {
				ctrlLog.telaListaLogPlaca(tfPlaca.getText());
			}
		}
		
	}

}
