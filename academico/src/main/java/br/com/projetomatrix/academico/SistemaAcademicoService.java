package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;

public class SistemaAcademicoService {
	
	private AlunoService alunoService = new AlunoService();
	private CoordenadorService coordenadorService = new CoordenadorService();
	private ProfessorService professorService = new ProfessorService();
	private CursoService cursoService = new CursoService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private HorarioService horarioService = new HorarioService();
	private TurmaService turmaService = new TurmaService();
	private AvaliacaoService avaliacaoService = new AvaliacaoService();
	
	public Aluno cadastrarAluno(Aluno aluno) {
		return alunoService.cadastrarAluno(aluno);
	}
	
	public void removerAluno(Aluno aluno) {
		alunoService.removerAluno(aluno);
	}
	
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoService.atualizarAluno(aluno);
	}
	
	public Coordenador cadastrarCoordenador(Coordenador coordenador) {
		return coordenadorService.cadastrarCoordenador(coordenador);
	}
	
	public void removerCoordenador(Coordenador coordenador) {
		coordenadorService.removerCoordenador(coordenador);
	}
	
	public Coordenador atualizarCoordenador(Coordenador coordenador) {
		return coordenadorService.atualizarCoordenador(coordenador);
	}
	
	public Professor cadastrarProfessor(Professor professor) {
		return professorService.cadastrarProfessor(professor);
	}
	
	public void removerProfessor(Professor professor) {
		professorService.removerProfessor(professor);
	}
	
	public Professor atualizarProfessor(Professor professor) {
		return professorService.atualizarProfessor(professor);
	}
	
	public Horario cadastrarHorario(Horario horario) {
		return horarioService.cadastrarHorario(horario);
	}
	
	public void removerHorario(Horario horario) {
		horarioService.removerHorario(horario);
	}
	
	public Horario atualizarHorario(Horario horario) {
		return horarioService.atualizarHorario(horario);
	}
	
	public Turma cadastrarTurma(Turma turma) {
		return turmaService.cadastrarTurma(turma);
	}
	
	public void removerTurma(Turma turma) {
		turmaService.removerTurma(turma);
	}
	
	public Turma atualizarTurma(Turma turma) {
		return turmaService.atualizarTurma(turma);
	}
	
	public List<Turma> recuperarTodasAsTurmas() {
		return turmaService.recuperarTodasAsTurmas();
	}
	
	public List<Turma> buscarAlunoEmTurmas(Aluno aluno) {
		return turmaService.buscarAlunoEmTurmas(aluno);
	}
	
	public List<Turma> buscarProfessoresEmTurmas(Professor professor) {
		return turmaService.buscarProfessoresEmTurmas(professor);
		
	}
	
	public void cadastrarAlunosEmTurmas(Aluno aluno, Turma turma) {
		turmaService.cadastrarAlunosEmTurmas(aluno, turma);
	}
	
	public void cadastrarProfessorEmTurmas(Professor professor, Turma turma) {
		turmaService.cadastrarProfessorEmTurmas(professor, turma);
		
	}
	
	public void cadastrarHorariosNaTurma(Horario horario, Turma turma) {
		
		turmaService.cadastrarHorariosNaTurma(horario, turma);
		
	}
	
	public Curso cadastrarCurso(Curso curso) {
		return cursoService.cadastrarCurso(curso);
	}
	
	public void removerCurso(Curso curso) {
		cursoService.removerCurso(curso);
	}
	
	public Curso atualizarCurso(Curso curso) {
		return cursoService.atualizarCurso(curso);
	}
	
	public void cadastrarDisciplinaNoCurso(Disciplina disciplina, Curso curso) {
		cursoService.cadastrarDisciplinaNoCurso(disciplina,curso);
	}
	
	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
		return avaliacaoService.cadastrarAvaliacao(avaliacao);
	}
	
	public void removerAvaliacao(Avaliacao avaliacao) {
		avaliacaoService.removerAvaliacao(avaliacao);
	}
	
	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {
		return avaliacaoService.atualizarAvaliacao(avaliacao);
	}
	
	public List<Avaliacao> getAvaliacoesAluno(Aluno aluno, Turma turma) {
		return avaliacaoService.getAvaliacoesAluno(aluno, turma);
	}
	
	public List<Avaliacao> recuperarTodasAvaliacoesAluno(Aluno aluno) {
		return avaliacaoService.recuperarTodasAvaliacoesAluno(aluno);
	}
	
	public BigDecimal getMediaAluno(Aluno aluno, Turma turma) {
		return avaliacaoService.getMediaAluno(aluno, turma);
	}
	
	public StatusAcademico getStatusAluno(Aluno aluno, Turma turma) {
		return avaliacaoService.getStatusAluno(aluno, turma);
	}
	
	public Disciplina cadastrarDisciplina(Disciplina disciplina) {
		return disciplinaService.cadastrarDisciplina(disciplina);
	}
	
	public void removerDisciplina(Disciplina disciplina) {
		disciplinaService.removerDisciplina(disciplina);
	}
	
	public Disciplina atualizarDisciplina(Disciplina disciplina) {
		return disciplinaService.atualizarDisciplina(disciplina);
	}
	
	public void cadastrarProfessorNaDisciplina(Disciplina disciplina, Professor professor) {
		disciplinaService.cadastrarProfessorNaDisciplina(disciplina, professor);
	}
	
	public Boletim gerarBoletim(Aluno aluno, Turma turma) {
		List<Avaliacao> avaliacoesAluno = avaliacaoService.getAvaliacoesAluno(aluno, turma);
		return new Boletim(aluno, turma, avaliacoesAluno);
	}
	
	// public Historico gerarHistorico(Aluno aluno) {
	// List<Boletim> boletins = gerarBoletim(aluno);
	// return new Historico(aluno, boletins);
	// }
	
}
