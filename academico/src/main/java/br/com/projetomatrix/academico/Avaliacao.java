package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Avaliacao {

	private Aluno aluno;
	private Turma turma;
	private LocalDate dataRealizacao;
	private String descricao;
	private ModoAvaliacao modoAvaliacao;
	private Professor responsavelPelaAplicacao;
	private String codigo;
	private BigDecimal nota;
	
	public Aluno getAluno() {
		return aluno;
	}
	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
	public Turma getTurma() {
		return turma;
	}
	public void setTurma(Turma turma) {
		this.turma = turma;
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
	public ModoAvaliacao getModoAvaliacao() {
		return modoAvaliacao;
	}
	public void setModoAvaliacao(ModoAvaliacao modoAvaliacao) {
		this.modoAvaliacao = modoAvaliacao;
	}
	public Professor getResponsavelPelaAplicacao() {
		return responsavelPelaAplicacao;
	}
	public void setResponsavelPelaAplicacao(Professor responsavelPelaAplicacao) {
		this.responsavelPelaAplicacao = responsavelPelaAplicacao;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public BigDecimal getNota() {
		return nota;
	}
	public void setNota(BigDecimal nota) {
		this.nota = nota;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aluno == null) ? 0 : aluno.hashCode());
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
		result = prime * result + ((dataRealizacao == null) ? 0 : dataRealizacao.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((modoAvaliacao == null) ? 0 : modoAvaliacao.hashCode());
		result = prime * result + ((nota == null) ? 0 : nota.hashCode());
		result = prime * result + ((responsavelPelaAplicacao == null) ? 0 : responsavelPelaAplicacao.hashCode());
		result = prime * result + ((turma == null) ? 0 : turma.hashCode());
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
		Avaliacao other = (Avaliacao) obj;
		if (aluno == null) {
			if (other.aluno != null)
				return false;
		} else if (!aluno.equals(other.aluno))
			return false;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		if (dataRealizacao == null) {
			if (other.dataRealizacao != null)
				return false;
		} else if (!dataRealizacao.equals(other.dataRealizacao))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (modoAvaliacao != other.modoAvaliacao)
			return false;
		if (nota == null) {
			if (other.nota != null)
				return false;
		} else if (!nota.equals(other.nota))
			return false;
		if (responsavelPelaAplicacao == null) {
			if (other.responsavelPelaAplicacao != null)
				return false;
		} else if (!responsavelPelaAplicacao.equals(other.responsavelPelaAplicacao))
			return false;
		if (turma == null) {
			if (other.turma != null)
				return false;
		} else if (!turma.equals(other.turma))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Avaliacao [aluno=" + aluno + ", turma=" + turma + ", dataRealizacao=" + dataRealizacao + ", descricao="
				+ descricao + ", modoAvaliacao=" + modoAvaliacao + ", responsavelPelaAplicacao="
				+ responsavelPelaAplicacao + ", codigo=" + codigo + ", nota=" + nota + "]";
	}
	
	

}
