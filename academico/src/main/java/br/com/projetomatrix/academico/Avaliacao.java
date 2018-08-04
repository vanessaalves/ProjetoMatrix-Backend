package br.com.projetomatrix.academico;

import java.time.LocalDate;

public class Avaliacao {
	//private Aluno aluno;
	//private Turma turma;
	private LocalDate dataRealizacao;
	private String descricao;
	private String modo; // presencial ou online
	private String responsavelAplicacao; // professor ou coordenador
	private String codigo;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public LocalDate getDataRealizacao() {
		return dataRealizacao;
	}
	public void setDataRealizacao(LocalDate dataRealizacao) {
		this.dataRealizacao = dataRealizacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getModo() {
		return modo;
	}
	public void setModo(String modo) {
		this.modo = modo;
	}
	public String getResponsavelAplicacao() {
		return responsavelAplicacao;
	}
	public void setResponsavelAplicacao(String responsavelAplicacao) {
		this.responsavelAplicacao = responsavelAplicacao;
	}
	
}
