package swing_examples2;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Exercicio2 {
	
	public static void main(String[] args) {

		JLabel lblTitulo = new JLabel();
		JLabel lblLogin = new JLabel();
		JLabel lblPassword = new JLabel();
		JTextField jTFLogin = new JTextField();
		JPasswordField jPFPassword = new JPasswordField();
		JButton btnOk = new JButton();
		JButton btnCancelar = new JButton();
		JFrame jFrameLogin = new JFrame();
		Container container = jFrameLogin.getContentPane();
		jFrameLogin.setContentPane(container);
		container.setLayout(null);
		lblTitulo.setFont(new Font("Arial", Font.BOLD, 12));
		lblTitulo.setBounds(90, 20, 180, 185);
		lblTitulo.setForeground(Color.red);
		container.add(lblTitulo);
		lblLogin.setText("Insira seu login!");
		container.add(lblLogin);
		lblPassword.setBounds(20, 90, 53, 15);
		container.add(lblPassword);
		jTFLogin.setBounds(80, 90, 210, 20);
		jTFLogin.setText("Insira seu login!");
		container.add(jTFLogin);
		jPFPassword.setBounds(80, 90, 210, 20);
		container.add(jPFPassword);
		JPanel jPanelBotoes = new JPanel();
		jPanelBotoes.setBounds(30, 120, 280, 60);
		jPanelBotoes.setLayout(null);
		jPanelBotoes.setBackground(Color.blue);
		container.add(jPanelBotoes);
		btnOk.setBounds(70, 20, 47, 23);
		jPanelBotoes.add(btnOk);
		btnCancelar.setBounds(150, 20, 75, 23);
		btnCancelar.setToolTipText("Sair do Programa");
		jPanelBotoes.add(btnCancelar);
	}
}
