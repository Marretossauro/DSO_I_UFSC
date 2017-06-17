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


public class TelaChamaLogByMot extends JFrame {

	private static final long serialVersionUID = -6600139587771507093L;
	private ControladorLog ctrlLog;
	private GerenciadorBotoesChama buttManager;
	
	// Components
	
	private JLabel lbMot;
	private JTextField tfMot;
	private JButton btOk;
	
	public TelaChamaLogByMot(ControladorLog owner) {
		super("Listar Registros por Motivo");
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

		lbMot = new JLabel();
		lbMot.setText("Motivo: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbMot, constraints);
		tfMot = new JTextField();
		tfMot.setText("");
		constraints.gridx = 1;
		constraints.gridy = 0;
		tfMot.setPreferredSize(new Dimension(100, 20));
		container.add(tfMot, constraints);
		
		// Ok Button

		btOk = new JButton();
		btOk.setActionCommand("ListarLM");
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
			if(e.getActionCommand().equals("ListarLM")) {
				ctrlLog.telaListaLogMot(tfMot.getText());
			}
		}
		
	}

}
