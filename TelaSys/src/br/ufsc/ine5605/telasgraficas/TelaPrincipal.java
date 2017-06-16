package br.ufsc.ine5605.telasgraficas;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private ControladorPrinc ctrl;
	private GerenciadorBotoes btManager;
	private JLabel lbNome;
	private JTextField tfNome;
	private JLabel lbFone;
	private JTextField tfFone;
	private JButton btOk;

	public TelaPrincipal(ControladorPrinc owner) {

		super("Deus é top");
		this.ctrl = owner;
		this.btManager = new GerenciadorBotoes();
		inicia();

	}

	public void inicia() {

		// Definir Container e Layout

		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Instanciar, configurar layout e adicionar no container

		// lbNome

		lbNome = new JLabel();
		lbNome.setText("Nome: ");
		constraints.gridx = 0;
		constraints.gridy = 0;
		container.add(lbNome, constraints);

		// tfNome

		tfNome = new JTextField();
		tfNome.setText(" ");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 0;
		tfNome.setPreferredSize(new Dimension(100, 20));
		container.add(tfNome, constraints);

		// lbFone

		lbFone = new JLabel();
		lbFone.setText("Telefone: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbFone, constraints);

		// tfFone

		tfFone = new JTextField();
		tfFone.setText(" ");
		constraints.fill = GridBagConstraints.HORIZONTAL;
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfFone.setPreferredSize(new Dimension(100, 20));
		container.add(tfFone, constraints);

		// btOk

		btOk = new JButton();
		btOk.setActionCommand("INCLUIR");
		btOk.addActionListener(ctrl);
		btOk.setText("OK");
		constraints.gridx = 1;
		constraints.gridy = 2;
		container.add(btOk, constraints);

		// Configurar JFrame

		setSize(250, 100);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoes implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("INCLUIR")) {
				ctrl.incluiFuncionario(tfNome.getText(), tfFone.getText());
			}
		}

	}

	public String getTfNomeText() {
		return tfNome.getText();
	}

	public String getTfFoneText() {
		return tfFone.getText();
	}

}
