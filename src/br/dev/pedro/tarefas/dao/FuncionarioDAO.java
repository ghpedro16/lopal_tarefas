package br.dev.pedro.tarefas.dao;

import java.io.BufferedWriter;
import java.io.IOException;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Funcionario;

public class FuncionarioDAO {

	private Funcionario funcionario;
	
	// Metodo construtor
	public FuncionarioDAO (Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public void gravar() {
		
		FileFactory ff = new FileFactory();
		
		try {
			BufferedWriter bw = ff.getBufferedWriter();
			
			bw.write(funcionario.toString());
			bw.flush();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void exibirFuncionarios () {
		
		
	}
	
	
	
}
