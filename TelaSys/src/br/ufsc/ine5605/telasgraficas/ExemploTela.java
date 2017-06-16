package br.ufsc.ine5605.telasgraficas;

import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;;

public class ExemploTela extends JFrame {

	private static final long serialVersionUID = 1L;
	private JButton botao;
	private JLabel label;

	public ExemploTela() {

		super("Primeiro frame - Tela Principal");

		Container container = getContentPane();

		container.setLayout(new FlowLayout());

		label = new JLabel();

		botao = new JButton();

		label.setText("Primeiro JLabel");

		botao.setText("\nPrimeiro botão;");

		container.add(label);

		container.add(botao);

		setSize(360, 10);

		setVisible(true);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

}
