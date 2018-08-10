package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class DisciplinaService {
	private int i = 1;
	private static Map<String, Disciplina> hashDisciplinas = new HashMap<>();
	private List<Professor> professorDisciplinas = new ArrayList<>();
	private List<Disciplina> preRequisitosDisciplinas = new ArrayList<>();
	
	public void cadastrarProfessorNaDisciplina(Disciplina disciplina, Professor professor) {
		if (ObjectUtils.isEmpty(disciplina) || ObjectUtils.isEmpty(professor)
				|| professor.getStatus().equals(Status.INATIVO))
			throw new IllegalArgumentException();
		professorDisciplinas.add(professor);
		disciplina.setProfessoresList(professorDisciplinas);
		
	}
	
	private static boolean verificarDisciplinasDuplicadas(Disciplina disciplina) {
		int cont = 0;
		for (Disciplina d : hashDisciplinas.values()) {
			if (d.getCurso().equals(disciplina.getCurso()))
				cont++;
		}
		return cont > 0 ? true : false;
	}
	
	// private void cadastrarPreRequisitosListDisciplina(Disciplina disciplina) {
	//
	// }
	
	public Disciplina cadastrarDisciplina(Disciplina disciplina) {
		if (ObjectUtils.isEmpty(disciplina) || verificarDisciplinasDuplicadas(disciplina))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(disciplina.getCodigo()) && hashDisciplinas.containsKey(disciplina.getCodigo()))
			return atualizarDisciplina(disciplina);
		
		disciplina.setCodigo(gerarCodigo(disciplina));
		hashDisciplinas.put(disciplina.getCodigo(), disciplina);
		
		return disciplina;
	}
	
	public void removerDisciplina(Disciplina disciplina) {
		if (ObjectUtils.isEmpty(disciplina))
			throw new IllegalArgumentException();
		
		hashDisciplinas.remove(disciplina.getCodigo());
	}
	
	public Disciplina atualizarDisciplina(Disciplina disciplina) {
		if (ObjectUtils.isEmpty(disciplina) || !hashDisciplinas.containsKey(disciplina.getCodigo()))
			throw new IllegalArgumentException();
		hashDisciplinas.put(disciplina.getCodigo(), disciplina);
		
		return disciplina;
	}
	
	public Disciplina recuperarDisciplina(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashDisciplinas.get(codigo);
	}
	
	private String gerarCodigo(Disciplina disciplina) {
		String codigo = "DISC1" + i++;
		
		return codigo;
	}
}
