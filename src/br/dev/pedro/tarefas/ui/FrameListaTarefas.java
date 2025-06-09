package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import br.dev.pedro.tarefas.dao.TarefasDAO;
import br.dev.pedro.tarefas.model.Tarefa;

public class FrameListaTarefas {
	
	private JLabel labelTitulo;
	private JTable tableTarefas;
	private JScrollPane scrollTarefas;
	private JButton btnNovo;
	private JButton btnSair;
	
	private Font fontTitulo = new Font("Arial", Font.BOLD, 26);

	public FrameListaTarefas() {
		criarTela();
	}
	
	private void criarTela() {
		JFrame tela = new JFrame();
		tela.setTitle("Lista de Tarefas");
		tela.setSize(600, 600);
		tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tela.setResizable(false);
		tela.setLayout(null);
		tela.setLocationRelativeTo(null);
		
		labelTitulo = new JLabel("Cadastro de Tarefas");
		labelTitulo.setBounds(10, 20, 500, 30);
		labelTitulo.setFont(fontTitulo);
		
		// Criação da tabela
		String[] colunas = {"Código", "Título", "Responsável"};
		
		// Lista de Tarefas
		TarefasDAO dao = new TarefasDAO(null);
		List<Tarefa> tarefas = dao.exibirTarefas();
		
		Object[][] dados = new Object[tarefas.size()][3];
		
		int linha = 0;
		for(Tarefa f : tarefas) {
			dados[linha][0] = f.getCodigo();
			dados[linha][1] = f.getTitulo();
			dados[linha][2] = f.getResponsavel();
			linha++;
		}
		
		tableTarefas = new JTable(dados, colunas);
		
		scrollTarefas = new JScrollPane(tableTarefas);
		scrollTarefas.setBounds(10, 70, 565, 400);
		
		btnNovo = new JButton("Cadastrar");
		btnNovo.setBounds(10, 490, 150, 40);
		
		btnSair = new JButton("Sair");
		btnSair.setBounds(170, 490, 150, 40);
		
		Container painel = tela.getContentPane();
		painel.add(labelTitulo);
		painel.add(scrollTarefas);
		painel.add(btnNovo);
		painel.add(btnSair);
		
		btnNovo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new FrameTarefas();
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
