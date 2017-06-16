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

import br.ufsc.ine5605.trab1.controllers.ControladorPrincipal;

public class TelaPrincipalGeral extends JFrame {

	private static final long serialVersionUID = -4317675814597596413L;
	private GerenciadorBotoesGeral buttManager;
	private ControladorPrincipal ctrlPrinc;

	// Components

	private JButton btFuncSys;
	private JButton btVeicSys;
	private JButton btEmpSys;
	private JButton btLogSys;

	public TelaPrincipalGeral(ControladorPrincipal owner) {
		super("Sistema Geral");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlPrinc = owner;
		this.buttManager = new GerenciadorBotoesGeral();
		init();
	}

	private void init() {

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();
		
		// Func controller
		
		btFuncSys = new JButton();
		btFuncSys.setActionCommand("ControladorFuncionario");
		btFuncSys.addActionListener(buttManager);
		btFuncSys.setText("Sistema de Funcionarios");
		btFuncSys.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(btFuncSys, constraints);
		
		// Car controller
		
		btVeicSys = new JButton();
		btVeicSys.setActionCommand("ControladorVeiculo");
		btVeicSys.addActionListener(buttManager);
		btVeicSys.setText("Sistema de Veiculos");
		btVeicSys.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(btVeicSys, constraints);
		
		// Emp controller
		
		btEmpSys = new JButton();
		btEmpSys.setActionCommand("ControladorEmprestimo");
		btEmpSys.addActionListener(buttManager);
		btEmpSys.setText("Sistema de Emprestimos");
		btEmpSys.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(btEmpSys, constraints);
		
		// Log controller
		
		btLogSys = new JButton();
		btLogSys.setActionCommand("ControladorLog");
		btLogSys.addActionListener(buttManager);
		btLogSys.setText("Sistema de Registros");
		btLogSys.setPreferredSize(new Dimension(350, 50));
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(btLogSys, constraints);
		
		// JFrame configuration
		
		setSize(500, 500);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	private class GerenciadorBotoesGeral implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			String opcao = e.getActionCommand();
			switch(opcao){
			case "ControladorFuncionario":
				ctrlPrinc.getCtrlFuncionario().inicia();
				break;
			case "ControladorVeiculo":
				ctrlPrinc.getCtrlVeiculo().inicia();
				break;
			case "ControladorEmprestimo":
				ctrlPrinc.getCtrlEmprestimo().inicia();
				break;
			case "ControladorLog":
				ctrlPrinc.getCtrlLog().inicia();
				break;
			default:
				break;
			}
		}
		
	}

}
