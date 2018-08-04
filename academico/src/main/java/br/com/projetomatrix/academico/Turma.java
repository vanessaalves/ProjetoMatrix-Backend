package br.com.projetomatrix.academico;

import java.time.LocalDate;
import java.time.Year;

public class Turma {
	//associado a uma disciplina, professor, alunos
  	//private Disciplina disciplina;
  	//private Professor professor;
  	//private Aluno[] Alunos; ,
	private Year anoLetivo;
  	private int semestre;
  	private LocalDate dataAbertura;
  	private LocalDate dataEncerramento; 
    private String horarioAula;
	
  	private String codigo;
  	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Year getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(Year anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public int getSemestre() {
		return semestre;
	}
	public void setSemestre(int semestre) {
		this.semestre = semestre;
	}
	public LocalDate getDataAbertura() {
		return dataAbertura;
	}
	public void setDataAbertura(LocalDate dataAbertura) {
		this.dataAbertura = dataAbertura;
	}
	public LocalDate getDataEncerramento() {
		return dataEncerramento;
	}
	public void setDataEncerramento(LocalDate dataEncerramento) {
		this.dataEncerramento = dataEncerramento;
	}
	public String getHorarioAula() {
		return horarioAula;
	}
	public void setHorarioAula(String horarioAula) {
		this.horarioAula = horarioAula;
	}
	
  	
}
