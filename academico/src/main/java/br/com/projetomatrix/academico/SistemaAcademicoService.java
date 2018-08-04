package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SistemaAcademicoService {
	
	public static Map<Integer, Pessoa> listaCadastro = new HashMap<>();
	static int i = 0;
	
	public static void cadastrar(Pessoa pessoa) {
		listaCadastro.put(i++, pessoa);
	}
	
	public static void remover(Pessoa pessoa) {
		listaCadastro.values().removeIf(v -> v.equals(pessoa));
	}
	
	public static List<Integer> listOfKeys = new ArrayList<>();
	
	public static void alterar(Pessoa pessoa) {
		
		// PEGAR A KEY
		// if (listaCadastro.containsValue(pessoa)) {
		// for (Map.Entry<Integer, Pessoa> entry : listaCadastro.entrySet()) {
		// if (entry.getValue().equals(pessoa)) {
		// Integer key = entry.getKey();
		// }
		// }
		// }
		
		//
		// for (Integer s : key)
		// System.out.println(s);
		
		// EXIBIR KEY E VALUE
		// listaCadastro.entrySet().forEach(entry -> {
		// System.out.println("Key : " + entry.getKey() + " Value : " +
		// entry.getValue());
		// });
		
	}
	
	public static void main(String args[]) {
		
		Pessoa pessoa = new Pessoa();
		Pessoa pessoa2 = new Pessoa("Luana", "Rua euehu", 626226, 20005, "ATIVO");
		
		pessoa.setNome("Ana");
		pessoa.setEndereço("Rua tal");
		pessoa.setMatricula(200015);
		pessoa.setStatus("ATIVO");
		pessoa.setTelefone(201526623);
		
		cadastrar(pessoa2);
		cadastrar(pessoa);
		alterar(pessoa);
		// System.out.println(listaCadastro.entrySet());
	}
	
}
