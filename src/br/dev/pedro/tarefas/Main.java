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
import br.dev.pedro.tarefas.ui.FrameFuncionario;
import br.dev.pedro.tarefas.ui.FrameListaFuncionario;
import br.dev.pedro.tarefas.utils.Utils;

public class Main {
	
	// Determinando o caminho do arquivo que será lido
	private static String path = "C:\\Users\\25132515\\tarefa\\tarefas.txt";

	public static void main(String[] args) {
		
		new FrameListaFuncionario();
		
//		new FrameFuncionario();
		
//		FuncionarioDAO dao = new FuncionarioDAO(new Funcionario());
//		List<Funcionario> funcionarios = dao.exibirFuncionarios();
//		
//		for (Funcionario f : funcionarios) {
//			System.out.println(f.getNome());
//		}
		
//		Funcionario funcionario = new Funcionario();
//		funcionario.setCodigo(Utils.gerarUUID());
//		funcionario.setNome("Rubens");
//		funcionario.setTelefone("25142871");
//		funcionario.setEmail("rubens@gmail.com");
//
//		Funcionario funcionario2 = new Funcionario();
//		funcionario2.setCodigo(Utils.gerarUUID());
//		funcionario2.setNome("Maria");
//		funcionario2.setTelefone("25140763");
//		funcionario2.setEmail("maria@gmail.com");
//		
//		FuncionarioDAO dao = new FuncionarioDAO(funcionario2);
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
