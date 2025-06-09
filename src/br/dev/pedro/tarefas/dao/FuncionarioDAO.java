package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	private FileFactory ff = new FileFactory();
	
	// Metodo construtor
	public FuncionarioDAO (Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		try {
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\25132515\\tarefa\\funcionarios.csv", true);
			
			bw.write(funcionario.toString());
			bw.flush();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Funcionario> exibirFuncionarios () {
		
		List<Funcionario> funcionarios = new ArrayList<>();
		
		try {
			BufferedReader br = ff.getBufferedReader("C:\\Users\\25132515\\tarefa\\funcionarios.csv");
			String linha = br.readLine();
			
			do {
				linha = br.readLine();
				String[] funcionario = linha != null ? linha.split(",") : null;
				
				Funcionario f = new Funcionario();
				f.setCodigo(funcionario[0]);
				f.setNome(funcionario[1]);
				f.setTelefone(funcionario[2]);
				f.setEmail(funcionario[3]);
				
				funcionarios.add(f);
				
			} while (linha != null);
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return funcionarios;
	}
	
	
	
}
