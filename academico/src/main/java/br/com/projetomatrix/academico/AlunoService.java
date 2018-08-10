package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class AlunoService {
	private int i = 0;
	private Map<String, Aluno> hashAlunos = new HashMap<>();
	
	public Aluno cadastrarAluno(Aluno aluno) {
		if (ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(aluno.getMatricula()) && hashAlunos.containsKey(aluno.getMatricula()))
			return atualizarAluno(aluno);
		
		aluno.setMatricula(gerarMatricula(aluno));
		hashAlunos.put(aluno.getMatricula(), aluno);
		
		return aluno;
	}
	
	public void removerAluno(Aluno aluno) {
		if (ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException();
		
		hashAlunos.remove(aluno.getMatricula());
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		if (ObjectUtils.isEmpty(aluno) || !hashAlunos.containsKey(aluno.getMatricula()))
			throw new IllegalArgumentException();
		hashAlunos.put(aluno.getMatricula(), aluno);
		
		return aluno;
	}
	
	public Aluno recuperarAluno(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashAlunos.get(codigo);
	}
	
	private String gerarMatricula(Aluno aluno) {
		String ano = Integer.toString(LocalDateTime.now().getYear());
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		String matricula = ano + semestre + i++;
		
		return matricula;
	}
	
}
