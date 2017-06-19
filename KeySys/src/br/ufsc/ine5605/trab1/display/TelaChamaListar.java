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

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;

public class TelaChamaListar extends JFrame {

	private static final long serialVersionUID = -8326939026229276243L;
	private ControladorFuncionario ctrlFunc;
	private GerenciadorBotoesChama buttManager;
	
	// Components
	
	private JLabel lbMat;
	private JTextField tfMat;
	private JButton btOk;
	
	public TelaChamaListar(ControladorFuncionario owner) {
		super("Listar Veiculos por Funcionarios");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlFunc = owner;
		this.buttManager = new GerenciadorBotoesChama();
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
		
		// Ok Button

		btOk = new JButton();
		btOk.setActionCommand("ListarVF");
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
			if(e.getActionCommand().equals("ListarVF")) {
				ctrlFunc.telaListVeicFunc(tfMat.getText());
			}
		}
		
	}

}
