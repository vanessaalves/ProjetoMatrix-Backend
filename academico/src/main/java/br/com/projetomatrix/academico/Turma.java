package br.com.projetomatrix.academico;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Turma {
	private String codigo;
	private Integer anoLetivo;
	private Integer semestre;
	private LocalDate dataAbertura;
	private LocalDate dataEncerramento;
	private List<Horario> horariosAula; 
	private Disciplina disciplina;
	private Professor professor;
	private List<Aluno> alunosList;
	@Override
	public String toString() {
		return "Turma [codigo=" + codigo + ", anoLetivo=" + anoLetivo + ", semestre=" + semestre + ", dataAbertura="
				+ dataAbertura + ", dataEncerramento=" + dataEncerramento + ", horariosAula=" + horariosAula
				+ ", disciplina=" + disciplina + ", professor=" + professor + ", alunosList=" + alunosList + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((alunosList == null) ? 0 : alunosList.hashCode());
		result = prime * result + ((anoLetivo == null) ? 0 : anoLetivo.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataAbertura == null) ? 0 : dataAbertura.hashCode());
		result = prime * result + ((dataEncerramento == null) ? 0 : dataEncerramento.hashCode());
		result = prime * result + ((disciplina == null) ? 0 : disciplina.hashCode());
		result = prime * result + ((horariosAula == null) ? 0 : horariosAula.hashCode());
		result = prime * result + ((professor == null) ? 0 : professor.hashCode());
		result = prime * result + ((semestre == null) ? 0 : semestre.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		if (alunosList == null) {
			if (other.alunosList != null)
				return false;
		} else if (!alunosList.equals(other.alunosList))
			return false;
		if (anoLetivo == null) {
			if (other.anoLetivo != null)
				return false;
		} else if (!anoLetivo.equals(other.anoLetivo))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataAbertura == null) {
			if (other.dataAbertura != null)
				return false;
		} else if (!dataAbertura.equals(other.dataAbertura))
			return false;
		if (dataEncerramento == null) {
			if (other.dataEncerramento != null)
				return false;
		} else if (!dataEncerramento.equals(other.dataEncerramento))
			return false;
		if (disciplina == null) {
			if (other.disciplina != null)
				return false;
		} else if (!disciplina.equals(other.disciplina))
			return false;
		if (horariosAula == null) {
			if (other.horariosAula != null)
				return false;
		} else if (!horariosAula.equals(other.horariosAula))
			return false;
		if (professor == null) {
			if (other.professor != null)
				return false;
		} else if (!professor.equals(other.professor))
			return false;
		if (semestre == null) {
			if (other.semestre != null)
				return false;
		} else if (!semestre.equals(other.semestre))
			return false;
		return true;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Integer getAnoLetivo() {
		return anoLetivo;
	}
	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
	public Integer getSemestre() {
		return semestre;
	}
	public void setSemestre(Integer semestre) {
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
	public List<Horario> getHorariosAula() {
		return horariosAula;
	}
	public void setHorariosAula(List<Horario> horariosAula) {
		this.horariosAula = horariosAula;
	}
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Professor getProfessor() {
		return professor;
	}
	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	public List<Aluno> getAlunosList() {
		return alunosList;
	}
	public void setAlunosList(List<Aluno> alunosList) {
		this.alunosList = alunosList;
	}
}
	
	