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

import br.ufsc.ine5605.trab1.controllers.ControladorLog;

public class TelaLogPrinc extends JFrame {

	private static final long serialVersionUID = 5364454538366260458L;
	private GerenciadorBotoesLogPrinc buttManager;
	private ControladorLog ctrlLog;
	
	// Components
	
	private JButton btListaTd;
	private JButton btListaMot;
	private JButton btListaMat;
	private JButton btListaPlac;

	public TelaLogPrinc(ControladorLog owner) {
		super("Sistema de Registros");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlLog = owner;
		this.buttManager = new GerenciadorBotoesLogPrinc();
		init();
	}
	
	private void init() {
		
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		// List all logs button
		
		btListaTd = new JButton();
		btListaTd.setActionCommand("ListaTdsLogs");
		btListaTd.setText("Lista Todos Registros");
		btListaTd.addActionListener(buttManager);
		btListaTd.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(btListaTd, constraints);
		
		// List logs by motive
		
		btListaMot = new JButton();
		btListaMot.setActionCommand("ListaLogMot");
		btListaMot.setText("Lista Registro por Motivo");
		btListaMot.addActionListener(buttManager);
		btListaMot.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(btListaMot, constraints);
		
		// List logs by register
		
		btListaMat = new JButton();
		btListaMat.setActionCommand("ListaLogMat");
		btListaMat.setText("Lista Registro por Matricula");
		btListaMat.addActionListener(buttManager);
		btListaMat.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(btListaMat, constraints);
		
		// List logs by car plate
		
		btListaPlac = new JButton();
		btListaPlac.setActionCommand("ListaLogPlac");
		btListaPlac.setText("Lista Registro por Placa");
		btListaPlac.addActionListener(buttManager);
		btListaPlac.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(btListaPlac, constraints);
		
		// JFrame configuration
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		
	}
	
	private class GerenciadorBotoesLogPrinc implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("ListaTdsLogs")){
				
			}
		}
		
	}

}
