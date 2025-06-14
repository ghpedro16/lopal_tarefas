package br.dev.pedro.tarefas.ui;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import br.dev.pedro.tarefas.dao.TarefasDAO;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.model.Status;
import br.dev.pedro.tarefas.model.Tarefa;
import br.dev.pedro.tarefas.utils.Utils;

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
	
	JComboBox<Status> boxStatus;
	JComboBox<String> boxFuncionario;
	
	private JButton btnSalvar;
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
		txtDataInicial.setEnabled(false);
		
		labelPrazo = new JLabel("Prazo: ");
		labelPrazo.setBounds(20, 215, 200, 30);
		txtPrazo = new JTextField();
		txtPrazo.setBounds(20, 245, 200, 30);
		txtPrazo.setEnabled(false);
		
		labelDataConclusao = new JLabel("Data Conclusão: ");
		labelDataConclusao.setBounds(20, 280, 200, 30);
		txtDataConclusao = new JTextField();
		txtDataConclusao.setBounds(20, 310, 200, 30);
		txtDataConclusao.setEnabled(false);
		
		labelStatus = new JLabel("Status: ");
		labelStatus.setBounds(20, 345, 200, 30);
		boxStatus = new JComboBox<Status>(Status.values());
		boxStatus.setBounds(20, 375, 200, 30);
		
		labelFuncionario = new JLabel("Funcionário: ");
		labelFuncionario.setBounds(20, 410, 200, 30);
		boxFuncionario = new JComboBox<>();
		lerArquivo("C:\\Users\\pedro\\tarefa\\funcionarios.csv");
		boxFuncionario.setBounds(20, 440, 200, 30);
		
		btnSalvar = new JButton("Salvar");
		btnSalvar.setBounds(20, 500, 100, 40);
		
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
		painel.add(boxStatus);
		painel.add(boxFuncionario);
		painel.add(btnSalvar);
		painel.add(btnSair);
		
		btnSalvar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Tarefa tarefa = new Tarefa();
				tarefa.setCodigo(Utils.gerarUUID());
				tarefa.setTitulo(txtTitulo.getText());
				tarefa.setDescricao(txtDescricao.getText());
//				tarefa.setDataInicial(null);
//				tarefa.setPrazo(null);
				tarefa.setStatus((Status) boxStatus.getSelectedItem());
				tarefa.setResponsavel((String) boxFuncionario.getSelectedItem());
				
				TarefasDAO dao = new TarefasDAO(tarefa);
				dao.gravar();
				
				JOptionPane.showMessageDialog(tela,
						"Tarefa gravada com sucesso!",
						"Sucesso",
						JOptionPane.INFORMATION_MESSAGE
				);
				
				limparFormulario();
				
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
	
	private void lerArquivo (String path) {
		try {
			BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\pedro\\tarefa\\funcionarios.csv"));
			br.readLine();
			String linha;
            while ((linha = br.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length > 0) {
                    boxFuncionario.addItem(partes[1]);
                }
            }
		} catch (IOException e) {
			e.getMessage();
		}
		
	}
	
	private void limparFormulario() {
		txtTitulo.setText(null);
		txtDescricao.setText(null);
		txtDataInicial.setText(null);
		txtPrazo.setText(null);
		txtDataConclusao.setText(null);
		txtTitulo.requestFocus();
	}


}
