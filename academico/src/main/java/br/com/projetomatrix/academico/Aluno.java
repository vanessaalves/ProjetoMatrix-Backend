package br.com.projetomatrix.academico;

public class Aluno {
	private Curso curso; 
	private Turma turma;

  	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
	}
}
