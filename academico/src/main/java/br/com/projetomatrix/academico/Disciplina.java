package br.com.projetomatrix.academico;

public class Disciplina {
	// private Disciplina[] preRequisitos;
	// private Professor[] professor;
	private Curso curso;
	private String descricao;
	private String codigo;
	
	public Curso getCurso() {
		return curso;
	}
	public void setCurso(Curso curso) {
		this.curso = curso;
	}
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
	
}
