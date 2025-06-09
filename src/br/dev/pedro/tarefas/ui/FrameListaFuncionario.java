package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.model.Funcionario;

public class FrameListaFuncionario {
	
	private JLabel labelTitulo;
	private JTable tableFuncionarios;
	private JScrollPane scrollFuncionarios;
	private JButton btnNovo;
	private JButton btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);
	
	public FrameListaFuncionario() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Funcionários");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		Container painel = tela.getContentPane();
		
		labelTitulo = new JLabel("Cadastro de Funcionários");
		labelTitulo.setBounds(10, 20, 500, 30);
		labelTitulo.setFont(fontTitulo);
		
		// Criação da tabela
		String[] colunas = {"Código", "Nome", "E-mail"};

		
		// Lista de funcionarios
		FuncionarioDAO dao = new FuncionarioDAO(null);
		List<Funcionario> funcionarios = dao.exibirFuncionarios();
		
		Object[][] dados = new Object[funcionarios.size()][3];
		
		int linha = 0;
		for(Funcionario f : funcionarios) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getNome();
			dados[linha][2] = f.getEmail();
			linha++;
		}
		
		tableFuncionarios = new JTable(dados, colunas);
		
		scrollFuncionarios = new JScrollPane(tableFuncionarios);
		scrollFuncionarios.setBounds(10, 70, 565, 400);
				
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(10, 490, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 490, 150, 40);
				
		painel.add(labelTitulo);		
		painel.add(scrollFuncionarios);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameFuncionario(tela);
				
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
