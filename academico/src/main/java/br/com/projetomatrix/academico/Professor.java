package br.com.projetomatrix.academico;

public class Professor extends Pessoa {
	private String titulo; // (graduação, especialização, mestrado, doutorado).
	//private Disciplina[] disciplina;
	
	
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
}
