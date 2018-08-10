package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class ProfessorService {
	private int i = 0;
	private Map<String, Professor> hashProfessores = new HashMap<>();
	
	public Professor cadastrarProfessor(Professor professor) {
		if (ObjectUtils.isEmpty(professor))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(professor.getMatricula()) && hashProfessores.containsKey(professor.getMatricula()))
			return atualizarProfessor(professor);
		
		professor.setMatricula(gerarMatricula(professor));
		hashProfessores.put(professor.getMatricula(), professor);
		
		return professor;
	}
	
	public void removerProfessor(Professor professor) {
		if (ObjectUtils.isEmpty(professor))
			throw new IllegalArgumentException();
		
		hashProfessores.remove(professor.getMatricula());
	}
	
	public Professor atualizarProfessor(Professor professor) {
		if (ObjectUtils.isEmpty(professor) || !hashProfessores.containsKey(professor.getMatricula()))
			throw new IllegalArgumentException();
		hashProfessores.put(professor.getMatricula(), professor);
		
		return professor;
	}
	
	public Professor recuperarProfessor(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashProfessores.get(codigo);
	}
	
	private String gerarMatricula(Professor professor) {
		String ano = Integer.toString(LocalDateTime.now().getYear());
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		String matricula = ano + semestre + i++;
		
		return matricula;
	}
}
