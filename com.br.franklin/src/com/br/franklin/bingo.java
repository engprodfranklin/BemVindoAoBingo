package com.br.franklin;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;



import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class bingo extends JFrame {

	private JPanel bemvindo_frame;
	private JTextField txt1_min;
	private JTextField txt2_max;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					bingo bemvindo_jframe = new bingo();
					bemvindo_jframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public bingo() {
		setTitle("BINGO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 557, 360);
		bemvindo_frame = new JPanel();
		bemvindo_frame.setBackground(Color.WHITE);
		bemvindo_frame.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(bemvindo_frame);
		bemvindo_frame.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("BEM VINDO AO BINGO");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(110, 10, 309, 43);
		bemvindo_frame.add(lblNewLabel);
		
		txt1_min = new JTextField();
		txt1_min.setHorizontalAlignment(SwingConstants.RIGHT);
		txt1_min.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt1_min.setBounds(110, 121, 120, 47);
		bemvindo_frame.add(txt1_min);
		txt1_min.setColumns(10);
		
		txt2_max = new JTextField();
		txt2_max.setFont(new Font("Tahoma", Font.PLAIN, 25));
		txt2_max.setHorizontalAlignment(SwingConstants.RIGHT);
		txt2_max.setColumns(10);
		txt2_max.setBounds(374, 121, 120, 47);
		bemvindo_frame.add(txt2_max);
		
		JLabel lblDesenvolvedorFranklinVincius = new JLabel("Desenvolvedor: Franklin Vin\u00EDcius / github.com.br/engprodfranklin");
		lblDesenvolvedorFranklinVincius.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblDesenvolvedorFranklinVincius.setBounds(10, 299, 395, 14);
		bemvindo_frame.add(lblDesenvolvedorFranklinVincius);
		
		JButton btn_iniciar = new JButton("INICIAR");
		btn_iniciar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int min_valor = Integer.parseInt(txt1_min.getText());
					int max_valor = Integer.parseInt(txt2_max.getText());	
					if (min_valor >= max_valor) {
						JOptionPane.showMessageDialog(null, "INFORME O INTERVALO CORRETAMENTE");
					} else {
						Sorteado sorteio = new Sorteado();	
						sorteio.Sorteado(min_valor, max_valor);	
					}						
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "INFORME O INTERVALO CORRETAMENTE");
				}
			}
		});
		btn_iniciar.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btn_iniciar.setBounds(146, 209, 259, 59);
		bemvindo_frame.add(btn_iniciar);
		
		JLabel lblDe = new JLabel("DE:");
		lblDe.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblDe.setBounds(48, 125, 52, 43);
		bemvindo_frame.add(lblDe);
		
		JLabel lblAt = new JLabel("AT\u00C9:");
		lblAt.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblAt.setBounds(313, 125, 64, 43);
		bemvindo_frame.add(lblAt);
		
		JLabel lblInformeOIntervalo = new JLabel("INFORME O INTERVALO");
		lblInformeOIntervalo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblInformeOIntervalo.setBounds(173, 83, 204, 28);
		bemvindo_frame.add(lblInformeOIntervalo);
	}
	
	public void telaInicial () {
		bemvindo_frame.setVisible(true);
	}
}
