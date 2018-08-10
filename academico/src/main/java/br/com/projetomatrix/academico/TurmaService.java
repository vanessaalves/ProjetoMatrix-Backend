package br.com.projetomatrix.academico;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class TurmaService {
	
	int i = 0;
	
	private Map<String, Turma> hashTurmas = new HashMap<>();
	private List<Horario> horariosList = new ArrayList<>();
	
	private List<Aluno> alunosList = new ArrayList<>();
	
	private Map<String, Aluno> alunosMap = new HashMap<>();
	
	public Turma cadastrarTurma(Turma turma) {
		if (ObjectUtils.isEmpty(turma) || verificarTurmasDuplicadas(turma))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(turma.getCodigo()) && hashTurmas.containsKey(turma.getCodigo()))
			return atualizarTurma(turma);
		
		turma.setCodigo(gerarCodigo(turma));
		hashTurmas.put(turma.getCodigo(), turma);
		
		return turma;
	}
	
	public void removerTurma(Turma turma) {
		if (ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		
		hashTurmas.remove(turma.getCodigo());
	}
	
	public Turma atualizarTurma(Turma turma) {
		if (ObjectUtils.isEmpty(turma) || !hashTurmas.containsKey(turma.getCodigo()))
			throw new IllegalArgumentException();
		hashTurmas.put(turma.getCodigo(), turma);
		
		return turma;
	}
	
	public Turma recuperarTurma(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashTurmas.get(codigo);
	}
	
	private String gerarCodigo(Turma turma) {
		
		String codigo = "T0" + turma.getSemestre() + i++;
		return codigo;
	}
	
	public List<Turma> recuperarTodasAsTurmas() {
		return new ArrayList<>(hashTurmas.values());
	}
	
	public List<Turma> buscarAlunoEmTurmas(Aluno aluno) {
		if (ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException();
		
		return hashTurmas.entrySet().stream().filter(map -> map.getValue().getAlunosList().contains(aluno))
				.map(map -> map.getValue()).collect(Collectors.toList());
	}
	
	public List<Turma> buscarProfessoresEmTurmas(Professor professor) {
		if (ObjectUtils.isEmpty(professor))
			throw new IllegalArgumentException();
		
		return hashTurmas.entrySet().stream().filter(map -> map.getValue().getProfessor().equals(professor))
				.map(map -> map.getValue()).collect(Collectors.toList());
	}
	
	public void cadastrarAlunosEmTurmas(Aluno aluno, Turma turma) {
		
		if (ObjectUtils.isEmpty(aluno) || ObjectUtils.isEmpty(turma) || aluno.getStatus().equals(Status.INATIVO))
			throw new IllegalArgumentException();
			
		// List<Turma> todasAsTurmas = recuperarTodasAsTurmas();
		// List<Turma> turmasLivres = todasAsTurmas.stream().filter(t -> {
		// return Collections.disjoint(t.getHorariosAula(), turma.getHorariosAula())
		// && !t.getAlunosList().contains(aluno);
		// }).collect(Collectors.toList());
		//
		// if (todasAsTurmas.size() != turmasLivres.size())
		// throw new IllegalArgumentException("Os horarios são conflitantes");
		//
		// Turma turmaEmMemoria = recuperarTurma(turma.getCodigo());
		// turmaEmMemoria.getAlunosList().add(aluno);
		// atualizarTurma(turmaEmMemoria);
		// return turmaEmMemoria;
		
		alunosMap.put(turma.getCodigo(), aluno);
		
		for (String c : alunosMap.keySet()) {
			if (c.contains(turma.getCodigo()))
				alunosList = alunosMap.values().stream().collect(Collectors.toList());
		}
		turma.setAlunosList(alunosList);
	}
	
	public void cadastrarProfessorEmTurmas(Professor professor, Turma turma) {
		if (ObjectUtils.isEmpty(professor) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		
		turma.setProfessor(professor);
	}
	
	public void cadastrarHorariosNaTurma(Horario horario, Turma turma) {
		if (ObjectUtils.isEmpty(horario) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		horariosList.add(horario);
		turma.setHorariosAula(horariosList);
	}
	
	private boolean verificarTurmasDuplicadas(Turma turma) {
		int cont = 0;
		for (Turma c : hashTurmas.values()) {
			if (c.getDisciplina().equals(turma.getDisciplina()))
				cont++;
		}
		return cont > 0 ? true : false;
	}
	
}