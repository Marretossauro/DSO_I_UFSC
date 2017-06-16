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
import javax.swing.UnsupportedLookAndFeelException;
import br.ufsc.ine5605.trab1.controllers.ControladorVeiculo;

public class TelaAlterarVeic extends JFrame {

	private static final long serialVersionUID = -5224512379375777654L;
	private ControladorVeiculo ctrlVeiculo;
	private GerenciadorBotoesVeic buttManager;

	// Components

	private JLabel lbPlaca;
	private JTextField tfPlaca;
	private JLabel lbPlacAtt;
	private JTextField tfPlacAtt;
	private JLabel lbModelo;
	private JTextField tfModelo;
	private JLabel lbMarca;
	private JTextField tfMarca;
	private JLabel lbAno;
	private JTextField tfAno;
	private JLabel lbQuilometragem;
	private JTextField tfQuilometragem;
	private JButton btOk;

	public TelaAlterarVeic(ControladorVeiculo owner) {
		super("Alterar Veiculo");
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
		}
		this.ctrlVeiculo = owner;
		this.buttManager = new GerenciadorBotoesVeic();
		init();
	}

	private void init() {
		Container container = getContentPane();
		container.setLayout(new GridBagLayout());
		GridBagConstraints constraints = new GridBagConstraints();

		// Car plate set

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

		// New car plate set
		
		lbPlacAtt = new JLabel();
		lbPlacAtt.setText("Nova Placa: ");
		constraints.gridx = 0;
		constraints.gridy = 1;
		container.add(lbPlacAtt, constraints);
		tfPlacAtt = new JTextField();
		tfPlacAtt.setText("");
		constraints.gridx = 1;
		constraints.gridy = 1;
		tfPlacAtt.setPreferredSize(new Dimension(100, 20));
		container.add(tfPlacAtt, constraints);
		
		// Model set

		lbModelo = new JLabel();
		lbModelo.setText("Modelo: ");
		constraints.gridx = 0;
		constraints.gridy = 2;
		container.add(lbModelo, constraints);
		tfModelo = new JTextField();
		tfModelo.setText("");
		constraints.gridx = 1;
		constraints.gridy = 2;
		tfModelo.setPreferredSize(new Dimension(100, 20));
		container.add(tfModelo, constraints);

		// Brand set

		lbMarca = new JLabel();
		lbMarca.setText("Marca: ");
		constraints.gridx = 0;
		constraints.gridy = 3;
		container.add(lbMarca, constraints);
		tfMarca = new JTextField();
		tfMarca.setText("");
		constraints.gridx = 1;
		constraints.gridy = 3;
		tfMarca.setPreferredSize(new Dimension(100, 20));
		container.add(tfMarca, constraints);

		// Year set

		lbAno = new JLabel();
		lbAno.setText("Ano: ");
		constraints.gridx = 0;
		constraints.gridy = 4;
		container.add(lbAno, constraints);
		tfAno = new JTextField();
		tfAno.setText("");
		constraints.gridx = 1;
		constraints.gridy = 4;
		tfAno.setPreferredSize(new Dimension(100, 20));
		container.add(tfAno, constraints);

		// KM set

		lbQuilometragem = new JLabel();
		lbQuilometragem.setText("Quilometragem: ");
		constraints.gridx = 0;
		constraints.gridy = 5;
		container.add(lbQuilometragem, constraints);
		tfQuilometragem = new JTextField();
		tfQuilometragem.setText("");
		constraints.gridx = 1;
		constraints.gridy = 5;
		tfQuilometragem.setPreferredSize(new Dimension(100, 20));
		container.add(tfQuilometragem, constraints);

		// OK Button

		btOk = new JButton();
		btOk.setActionCommand("Alterar");
		btOk.addActionListener(buttManager);
		btOk.setText("Alterar!");
		constraints.gridx = 1;
		constraints.gridy = 6;
		container.add(btOk, constraints);

		// JFrame Configuration

		setSize(550, 350);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);

	}

	private class GerenciadorBotoesVeic implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getActionCommand().equals("Alterar")) {
				try {
					ctrlVeiculo.alterar(tfPlaca.getText(), tfPlacAtt.getText(),tfModelo.getText(), tfMarca.getText(),
							Integer.parseInt(tfAno.getText()), Integer.parseInt(tfQuilometragem.getText()));
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Preencha todos os campos!");
					setVisible(false);
					dispose();
				}
			}
		}

	}

}
