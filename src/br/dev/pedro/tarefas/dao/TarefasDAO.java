package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.factory.FileFactory;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.model.Tarefa;

public class TarefasDAO {
	
	private Tarefa tarefa;
	private FileFactory ff = new FileFactory();
	
	// Metodo construtor
	public TarefasDAO (Tarefa tarefa) {
		this.tarefa = tarefa;
	}
	
	public void gravar() {
		try {
			// Senai: "C:\\Users\\25132515\\tarefa\\tarefas.csv"
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\pedro\\tarefa\\tarefas.csv", true);
			
			bw.write(tarefa.toString());
			bw.flush();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Tarefa> exibirTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		try {
			// Senai: "C:\\Users\\25132515\\tarefa\\tarefas.csv"
			BufferedReader br = ff.getBufferedReader("C:\\Users\\pedro\\tarefa\\tarefas.csv");
			String linha = br.readLine();
			
			do {
				linha = br.readLine();
				String[] tarefa = linha != null ? linha.split(",") : null;
				
				Tarefa t = new Tarefa();
				
				if (tarefa != null) {
					t.setCodigo(tarefa[0]);
					t.setTitulo(tarefa[1]);
					t.setResponsavel();
					
					tarefas.add(t);
				}
				
				
			} while (linha != null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return tarefas;
	} 
	

}
