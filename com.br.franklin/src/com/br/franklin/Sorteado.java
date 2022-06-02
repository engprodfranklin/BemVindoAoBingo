package com.br.franklin;

import java.awt.EventQueue;


import java.util.Random;
import java.util.TreeSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.SystemColor;
import java.awt.Color;

public class Sorteado {
	int min_valor, max_valor;
	public JFrame sorteio_frame;

	// Construtor Vazio
	public Sorteado() {
	}

	/**
	 * @wbp.parser.entryPoint
	 */
	public void Sorteado(int min_valor, int max_valor) {
		TreeSet<String> guarde = new TreeSet<String>();

		sorteio_frame = new JFrame();
		sorteio_frame.setBackground(new Color(128, 0, 128));
		sorteio_frame.getContentPane().setBackground(new Color(224, 255, 255));
		sorteio_frame.setTitle("BEM VINDO AO BINGO");
		sorteio_frame.setBounds(100, 100, 796, 512);
		sorteio_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		sorteio_frame.getContentPane().setLayout(null);

		JLabel label_gerado = new JLabel("0");
		label_gerado.setBackground(new Color(0, 128, 0));
		label_gerado.setHorizontalAlignment(SwingConstants.CENTER);
		label_gerado.setFont(new Font("Tahoma", Font.PLAIN, 99));
		label_gerado.setBounds(525, 29, 233, 164);
		sorteio_frame.getContentPane().add(label_gerado);

		JLabel lblNewLabel = new JLabel("N\u00DAMEROS SORTEADOS");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(10, 10, 233, 25);
		sorteio_frame.getContentPane().add(lblNewLabel);

		JTextArea txt1_area = new JTextArea();
		txt1_area.setBackground(new Color(255, 255, 255));
		txt1_area.setEditable(false);
		txt1_area.setWrapStyleWord(true);
		txt1_area.setLineWrap(true);
		txt1_area.setFont(new Font("Monospaced", Font.PLAIN, 20));
		txt1_area.setBounds(10, 43, 477, 288);
		sorteio_frame.getContentPane().add(txt1_area);

		JButton btn_sortear = new JButton("SORTEAR");
		btn_sortear.setBackground(new Color(211, 211, 211));
		btn_sortear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Randomico
				Random rand = new Random();
				boolean verdadeiro = true;
				String resultado = null;
				int intervalo = 0;
				while (verdadeiro) {
					int randomNum = min_valor + rand.nextInt((max_valor - min_valor) + 1);
					intervalo = (max_valor - min_valor) + 1;
					resultado = String.valueOf(randomNum);
					verdadeiro = guarde.contains(resultado);
				}
				guarde.add(resultado);
				// Entrada de valor no número sorteado
				if (verdadeiro == false) {
					label_gerado.setText(resultado);
				}
				// Mostragem de todos os números sorteados

				if (txt1_area.getText().equals("")) {
					txt1_area.setText(String.valueOf(guarde) + ", ");
				} else {
					txt1_area.setText(String.valueOf(guarde));
				}
				// Verificação de Finalização do BINGO
				if (intervalo == guarde.size()) {
					JOptionPane.showMessageDialog(null, "OBRIGADO POR PARTICIPAR");
					btn_sortear.setEnabled(false);
				}
			}
		});
		btn_sortear.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_sortear.setBounds(506, 217, 268, 66);
		sorteio_frame.getContentPane().add(btn_sortear);

		JButton btn_resetar = new JButton("RESETAR");
		btn_resetar.setBackground(new Color(211, 211, 211));
		btn_resetar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int respostaResetar = JOptionPane.showConfirmDialog(null, "DESEJA CONTINUAR?", "CONFIRMAÇÃO", 0);
				if (respostaResetar == JOptionPane.YES_OPTION) {
					guarde.clear();
					txt1_area.setText("");
					label_gerado.setText("0");
					btn_sortear.setEnabled(true);
				} else {
					return;
				}

			}
		});
		btn_resetar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_resetar.setBounds(506, 307, 268, 66);
		sorteio_frame.getContentPane().add(btn_resetar);

		JLabel lblIntervalo = new JLabel("INTERVALO");
		lblIntervalo.setHorizontalAlignment(SwingConstants.LEFT);
		lblIntervalo.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblIntervalo.setBounds(10, 341, 105, 19);
		sorteio_frame.getContentPane().add(lblIntervalo);

		JLabel lblIncio = new JLabel("IN\u00CDCIO:");
		lblIncio.setHorizontalAlignment(SwingConstants.LEFT);
		lblIncio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblIncio.setBounds(10, 370, 52, 19);
		sorteio_frame.getContentPane().add(lblIncio);

		JLabel lblTer = new JLabel("T\u00C9RMINO:");
		lblTer.setHorizontalAlignment(SwingConstants.LEFT);
		lblTer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTer.setBounds(10, 397, 71, 19);
		sorteio_frame.getContentPane().add(lblTer);

		JLabel lbl_inicio = new JLabel("");
		lbl_inicio.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_inicio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_inicio.setBounds(72, 370, 52, 19);
		lbl_inicio.setText(String.valueOf(min_valor));
		sorteio_frame.getContentPane().add(lbl_inicio);

		JLabel lbl_termino = new JLabel("");
		lbl_termino.setHorizontalAlignment(SwingConstants.LEFT);
		lbl_termino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lbl_termino.setBounds(91, 397, 52, 19);
		lbl_termino.setText(String.valueOf(max_valor));
		sorteio_frame.getContentPane().add(lbl_termino);

		JButton btn_telaInicial = new JButton("VOLTAR A TELA INICIAL");
		btn_telaInicial.setBackground(new Color(211, 211, 211));
		btn_telaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bingo voltarTelaInicial = new bingo();
				int respostaVoltar = JOptionPane.showConfirmDialog(null, "DESEJA CONTINUAR?", "CONFIRMAÇÃO", 0);
				if (respostaVoltar == JOptionPane.YES_OPTION) {
					// Ter acesso a outra tela
					voltarTelaInicial.telaInicial();
					// Fechar janela atual
					sorteio_frame.dispose();
				} else {
					return;
				}

			}
		});
		btn_telaInicial.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btn_telaInicial.setBounds(506, 387, 268, 66);
		sorteio_frame.getContentPane().add(btn_telaInicial);

		JLabel lblDesenvolvedorFranklinVincius = new JLabel(
				"Desenvolvedor: Franklin Vin\u00EDcius / github.com.br/engprodfranklin");
		lblDesenvolvedorFranklinVincius.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesenvolvedorFranklinVincius.setBounds(10, 451, 395, 14);
		sorteio_frame.getContentPane().add(lblDesenvolvedorFranklinVincius);

		sorteio_frame.setVisible(true);
	}
}
