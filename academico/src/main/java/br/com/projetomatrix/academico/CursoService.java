package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class CursoService {
	private int i = 1;
	private Map<String, Curso> hashCursos = new HashMap<>();
	private List<Disciplina> disciplinasCurso = new ArrayList<>();
	
	public Curso cadastrarCurso(Curso curso) {
		if (ObjectUtils.isEmpty(curso))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(curso.getCodigo()) && hashCursos.containsKey(curso.getCodigo()))
			return atualizarCurso(curso);
		
		curso.setCodigo(gerarCodigo(curso));
		hashCursos.put(curso.getCodigo(), curso);
		
		return curso;
	}
	
	public void removerCurso(Curso curso) {
		if (ObjectUtils.isEmpty(curso))
			throw new IllegalArgumentException();
		
		hashCursos.remove(curso.getCodigo());
	}
	
	public Curso atualizarCurso(Curso curso) {
		if (ObjectUtils.isEmpty(curso) || !hashCursos.containsKey(curso.getCodigo()))
			throw new IllegalArgumentException();
		hashCursos.put(curso.getCodigo(), curso);
		
		return curso;
	}
	
	public Curso recuperarCurso(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashCursos.get(codigo);
	}
	
	public void cadastrarDisciplinaNoCurso(Disciplina disciplina, Curso curso) {
		if (ObjectUtils.isEmpty(disciplina) || ObjectUtils.isEmpty(curso))
			throw new IllegalArgumentException();
		disciplinasCurso.add(disciplina);
		curso.setDisciplinas(disciplinasCurso);
		
	}
	private String gerarCodigo(Curso curso) {
		String codigo = "CUR1" + i++;
		return codigo;
	}
	
}
