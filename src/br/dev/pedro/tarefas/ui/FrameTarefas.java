package br.dev.pedro.tarefas.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class FrameTarefas {
	
	private JLabel labelCodigo;
	private JLabel labelNome;
	private JLabel labelDescricao;
	private JLabel labelFuncionario;
	
	private JTextField txtCodigo;
	private JTextField txtNome;
	private JTextField txtDescricao;
	
	private JButton btnGravar;
	
	public FrameTarefas() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame("Cadastro de Tarefas");
		tela.setLayout(null);
		tela.setSize(400, 400);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		labelCodigo = new JLabel("Código");
		labelCodigo.setBounds(20, 20, 200, 30);
		txtCodigo = new JTextField();
		txtCodigo.setBounds(20, 50, 200, 30);
		txtCodigo.setEnabled(false);
		
		labelNome = new JLabel("Nome: ");
		labelNome.setBounds(20, 85, 200, 30);
		txtNome = new JTextField();
		txtNome.setBounds(20, 115, 350, 30);
		
		labelDescricao = new JLabel("Descrição: ");
		labelDescricao.setBounds(20, 150, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 180, 200, 30);
		
		labelFuncionario = new JLabel("Funcionário: ");
		labelFuncionario.setBounds(20, 215, 200, 30);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setBounds(20, 290, 100, 40);
		
		Container painel = tela.getContentPane();
		painel.add(labelCodigo);
		painel.add(labelNome);
		painel.add(labelDescricao);
		painel.add(labelFuncionario);
		painel.add(txtCodigo);
		painel.add(txtNome);
		painel.add(txtDescricao);
		painel.add(btnGravar);
		
		
		tela.setVisible(true);
	}


}
