package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class FrameTarefas {
	
	private JLabel labelTitulo;
	private JLabel labelDescricao;
	private JLabel labelDataInicial;
	private JLabel labelPrazo;
	private JLabel labelDataConclusao;
	private JLabel labelStatus;
	private JLabel labelFuncionario;
	
	private JTextField txtTitulo;
	private JTextField txtDescricao;
	private JTextField txtDataInicial;
	private JTextField txtPrazo;
	private JTextField txtDataConclusao;
	
	private JButton btnGravar;
	private JButton btnSair;
	
	public FrameTarefas() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame("Cadastro de Tarefas");
		tela.setLayout(null);
		tela.setSize(400, 600);
		tela.setLocationRelativeTo(null);
		tela.setResizable(false);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		labelTitulo = new JLabel("Título");
		labelTitulo.setBounds(20, 20, 200, 30);
		txtTitulo = new JTextField();
		txtTitulo.setBounds(20, 50, 200, 30);
		
		labelDescricao = new JLabel("Descrição: ");
		labelDescricao.setBounds(20, 85, 200, 30);
		txtDescricao = new JTextField();
		txtDescricao.setBounds(20, 115, 350, 30);
		
		labelDataInicial = new JLabel("Data Inicial: ");
		labelDataInicial.setBounds(20, 150, 200, 30);
		txtDataInicial = new JTextField();
		txtDataInicial.setBounds(20, 180, 200, 30);
		
		labelPrazo = new JLabel("Prazo: ");
		labelPrazo.setBounds(20, 215, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 245, 200, 30);
		
		labelDataConclusao = new JLabel("Data Conclusão: ");
		labelDataConclusao.setBounds(20, 280, 200, 30);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 310, 200, 30);
		
		labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(20, 345, 200, 30);
		
		labelFuncionario = new JLabel("Funcionário: ");
		labelFuncionario.setBounds(20, 410, 200, 30);
		
		btnGravar = new JButton("Gravar");
		btnGravar.setBounds(20, 500, 100, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(130, 500, 100, 40);
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(labelDescricao);
		painel.add(labelDataInicial);
		painel.add(labelPrazo);
		painel.add(labelDataConclusao);
		painel.add(labelStatus);
		painel.add(labelFuncionario);
		painel.add(txtTitulo);
		painel.add(txtDescricao);
		painel.add(txtDataInicial);
		painel.add(txtPrazo);
		painel.add(txtDataConclusao);
		painel.add(btnGravar);
		painel.add(btnSair);
		
		btnGravar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
			}
		});
		
		btnSair.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				int resposta = JOptionPane.showConfirmDialog(
						tela,
						"Confirma a saída do sistema?",
						"Sair do sistema",
						JOptionPane.YES_NO_OPTION
				);
				
				if (resposta == 0) {
					tela.dispose();
				}
				
			}
		});
		
		tela.setVisible(true);
	}


}
