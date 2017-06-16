package br.ufsc.ine5605.trab1.display;

import java.awt.Container;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import br.ufsc.ine5605.trab1.controllers.ControladorFuncionario;
import br.ufsc.ine5605.trab1.objects.TipoCargo;

public class TelaAlterarFunc extends JFrame {

	private static final long serialVersionUID = 2219916928628811014L;
	private ControladorFuncionario ctrlFuncionario;
	private GerenciadorBotoesFuncio buttManager;

	// Components

	private JLabel lbMat;
	private JTextField tfMat;
	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbDataDeNascimento;
	private JTextField tfDataDeNascimento;
	private JLabel lbTelefone;
	private JTextField tfTelefone;
	private JComboBox<TipoCargo> cbCargo;
	private String[] cargos = { TipoCargo.DIRETORIA.toString(), TipoCargo.FINANCEIRO.toString(),
			TipoCargo.LIMPEZA.toString(), TipoCargo.MARKETING.toString(), TipoCargo.RH.toString(),
			TipoCargo.SEGURANCA.toString() };
	private JButton btOk;

	public TelaAlterarFunc(ControladorFuncionario owner) {
		super("Alterar Funcionario");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlFuncionario = owner;
		this.buttManager = new GerenciadorBotoesFuncio();
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

		// Name set

		lbNome = new JLabel();
		lbNome.setText("Nome: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbNome, constraints);
		tfNome = new JTextField();
		tfNome.setText("");
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfNome.setPreferredSize(new Dimension(100, 20));
		container.add(tfNome, constraints);

		// Birth date set

		lbDataDeNascimento = new JLabel();
		lbDataDeNascimento.setText("Data de nascimento: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(lbDataDeNascimento, constraints);
		tfDataDeNascimento = new JTextField();
		tfDataDeNascimento.setText("");
		constraints.gridx = 1;
		constraints.gridy = 2;
		tfDataDeNascimento.setPreferredSize(new Dimension(100, 20));
		container.add(tfDataDeNascimento, constraints);

		// Phone number set

		lbTelefone = new JLabel();
		lbTelefone.setText("Telefone: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(lbTelefone, constraints);
		tfTelefone = new JTextField();
		tfTelefone.setText("");
		constraints.gridx = 1;
		constraints.gridy = 3;
		tfTelefone.setPreferredSize(new Dimension(100, 20));
		container.add(tfTelefone, constraints);

		// Job role ComboBox

		cbCargo = new JComboBox(cargos);
		constraints.gridx = 1;
		constraints.gridy = 4;
		container.add(cbCargo, constraints);

		// Ok Button

		btOk = new JButton();
		btOk.setActionCommand("Alterar");
		btOk.addActionListener(buttManager);
		btOk.setText("Alterar!");
		constraints.gridx = 1;
		constraints.gridy = 5;
		container.add(btOk, constraints);

		// JFrame configuration

		setSize(550, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private class GerenciadorBotoesFuncio implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Alterar")) {
				try {
					ctrlFuncionario.alterar(tfMat.getText(), tfNome.getText(), tfDataDeNascimento.getText(),
							tfTelefone.getText(), cbCargo.getSelectedIndex() + 1);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
					setVisible(false);
					dispose();
				}
			}
		}

	}

}
