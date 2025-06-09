package br.dev.pedro.tarefas.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.factory.FileFactory;
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
			BufferedWriter bw = ff.getBufferedWriter("C:\\Users\\25132515\\tarefa\\tarefas.csv", true);
			
			bw.write(tarefa.toString());
			bw.flush();
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public List<Tarefa> exibirTarefas() {
		
		List<Tarefa> tarefas = new ArrayList<>();
		
		try {
			BufferedReader br = ff.getBufferedReader("C:\\Users\\25132515\\tarefa\\tarefas.csv");
			String linha = br.readLine();
			
			do {
				linha = br.readLine();
				String[] tarefa = linha != null ? linha.split(",") : null;
				
				Tarefa t = new Tarefa();
				t.setTitulo(tarefa[0]);
				t.setDescricao(tarefa[1]);
				t.setDataInicial(null);
				t.setPrazo(null);
				t.setStatus(null);
				t.setResponsavel(null);
				
				tarefas.add(t);
				
			} while (linha != null);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return tarefas;
	} 
	

}
