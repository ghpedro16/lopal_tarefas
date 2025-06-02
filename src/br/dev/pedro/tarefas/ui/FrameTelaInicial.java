package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class FrameTelaInicial {
	
	private JLabel lblTitulo;
	private JButton btnFuncionario;
	private JButton btnTarefas;
	
	public FrameTelaInicial() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame("Tela Inicial");
		tela.setSize(400, 400);
		tela.setLocationRelativeTo(null);
		tela.setLayout(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		lblTitulo = new JLabel("Selecione a opção desejada: ");
		lblTitulo.setBounds(100, 20, 300, 90);
		
		btnFuncionario = new JButton("Funcionário");
		btnFuncionario.setBounds(40, 120, 300, 90);
		
		btnTarefas = new JButton("Tarefas");
		btnTarefas.setBounds(40, 230, 300, 90);
		
		Container painel = tela.getContentPane();
		
		painel.add(btnFuncionario);
		painel.add(btnTarefas);
		painel.add(lblTitulo);
		
		btnFuncionario.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameListaFuncionario();
				
			}
		});
		
		btnTarefas.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefas();
				
			}
		});
		
		tela.setVisible(true);
	}

}
