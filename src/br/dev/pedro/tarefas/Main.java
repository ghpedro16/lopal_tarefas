package br.dev.pedro.tarefas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import br.dev.pedro.tarefas.dao.FuncionarioDAO;
import br.dev.pedro.tarefas.model.Funcionario;
import br.dev.pedro.tarefas.model.Tarefa;

public class Main {
	
	// Determinando o caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132515\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		List<String> frutas = new ArrayList<String>();
		List<Funcionario> funcionarios = new ArrayList<Funcionario>();
		List<Double> numeros = new ArrayList<Double>();
		
		frutas.add("abacaxi");
		frutas.add("goiaba");
		frutas.add("maçã");
		frutas.add("mamão");
		
		numeros.add(4.9);
		numeros.add(6.7);
		
		Funcionario funcionario = new Funcionario();
		funcionario.setCodigo(5);
		funcionario.setNome("Rubens");
		funcionario.setMatricula("25142871");
		funcionario.setEmail("rubens@gmail.com");

		Funcionario funcionario2 = new Funcionario();
		funcionario.setCodigo(6);
		funcionario.setNome("Cecilia");
		funcionario.setMatricula("25140763");
		funcionario.setEmail("cecilia@gmail.com");
		
		funcionarios.add(funcionario);
		
		System.out.println(frutas);
		System.out.println(funcionarios);
		
		for (Funcionario f : funcionarios) {
			System.out.println(f.getNome());
			System.out.println(f.getEmail());
		}
		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario);
//		dao.gravar();
//		
//		System.out.println(funcionario.toString());
		
	}
	
	private static void gravarArquivo() {
		
		FileWriter file = null;
		BufferedWriter writer = null;
		
		try {
			file = new FileWriter(path, true);
			writer = new BufferedWriter(file);
			
			writer.write("Essa é outra mais uma nova linha\n");
			writer.flush();
			
		} catch (Exception erro) {
			System.out.println(erro.getMessage());
		}
	}

	private static void lerArquivo() {
		
		// Abrir o arquivo para leitura
		FileReader file = null;
		BufferedReader buffer = null;
		try {
			file = new FileReader(path);
			buffer = new BufferedReader(file);
			
			String linha = "";
			
			while (linha != "") {
				System.out.println(linha);
				linha = buffer.readLine();
			}
			
		} catch (FileNotFoundException erro) {
			System.out.println("Arquivo não achado");
			System.out.println(erro.getMessage());
		} catch (IOException erro) {
			System.out.println("Você não pode ler o arquivo");
			System.out.println(erro.getMessage());
		} catch (Exception erro) {
			System.out.println("Erro genérico");
			System.out.println(erro.getMessage());
		}
	}

}
