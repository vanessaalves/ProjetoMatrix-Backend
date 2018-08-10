package br.com.projetomatrix.academico;

import java.util.List;

public class Disciplina {
	
	private String descricao;
	private String codigo;
	private List<Disciplina> preRequisitos;
	private List<Professor> professoresList;
	private Curso curso;
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public List<Disciplina> getPreRequisitos() {
		return preRequisitos;
	}
	public void setPreRequisitos(List<Disciplina> preRequisitos) {
		this.preRequisitos = preRequisitos;
	}
	public List<Professor> getProfessoresList() {
		return professoresList;
	}
	public void setProfessoresList(List<Professor> professoresList) {
		this.professoresList = professoresList;
	}
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
	@Override
	public String toString() {
		return "Disciplina [descricao=" + descricao + ", codigo=" + codigo + ", preRequisitos=" + preRequisitos
				+ ", professoresList=" + professoresList + ", curso=" + curso + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((curso == null) ? 0 : curso.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((preRequisitos == null) ? 0 : preRequisitos.hashCode());
		result = prime * result + ((professoresList == null) ? 0 : professoresList.hashCode());
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
		Disciplina other = (Disciplina) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (curso == null) {
			if (other.curso != null)
				return false;
		} else if (!curso.equals(other.curso))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (preRequisitos == null) {
			if (other.preRequisitos != null)
				return false;
		} else if (!preRequisitos.equals(other.preRequisitos))
			return false;
		if (professoresList == null) {
			if (other.professoresList != null)
				return false;
		} else if (!professoresList.equals(other.professoresList))
			return false;
		return true;
	}
}
