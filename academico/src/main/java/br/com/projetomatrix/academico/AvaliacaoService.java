package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class AvaliacaoService {
	
	int i = 1;
	private Map<String, Avaliacao> hashAvaliacoes = new HashMap<>();
	private List<Avaliacao> avaliacoesdoAlunonaTurma = new ArrayList<>();
	public int qtdAvaliacoesCadastradas;
	
	public Avaliacao cadastrarAvaliacao(Avaliacao avaliacao) {
		
		getAvaliacoesAluno(avaliacao.getAluno(), avaliacao.getTurma());
		if (ObjectUtils.isEmpty(avaliacao) || qtdAvaliacoesCadastradas > 2)
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(avaliacao.getCodigo()) && hashAvaliacoes.containsKey(avaliacao.getCodigo()))
			return atualizarAvaliacao(avaliacao);
		
		avaliacao.setCodigo(gerarCodigo(avaliacao));
		hashAvaliacoes.put(avaliacao.getCodigo(), avaliacao);
		return avaliacao;
	}
	
	public void removerAvaliacao(Avaliacao avaliacao) {
		if (ObjectUtils.isEmpty(avaliacao))
			throw new IllegalArgumentException();
		
		hashAvaliacoes.remove(avaliacao.getCodigo());
	}
	
	public Avaliacao atualizarAvaliacao(Avaliacao avaliacao) {
		if (ObjectUtils.isEmpty(avaliacao))
			throw new IllegalArgumentException();
		
		hashAvaliacoes.remove(avaliacao.getCodigo());
		return avaliacao;
	}
	
	public Avaliacao recuperarAvaliacao(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashAvaliacoes.get(codigo);
	}
	
	private String gerarCodigo(Avaliacao avaliacao) {
		String codigo = "AV" + i++;
		return codigo;
	}
	
	public List<Avaliacao> getAvaliacoesAluno(Aluno aluno, Turma turma) {
		if (ObjectUtils.isEmpty(aluno) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		avaliacoesdoAlunonaTurma = hashAvaliacoes.values().stream()
				.filter(map -> map.getAluno().getMatricula().equals(aluno.getMatricula())
						&& map.getTurma().getCodigo().equals(turma.getCodigo()))
				.collect(Collectors.toList());
		
		qtdAvaliacoesCadastradas = avaliacoesdoAlunonaTurma.size();
		
		return avaliacoesdoAlunonaTurma;
		
	}
	
	public List<Avaliacao> recuperarTodasAvaliacoesAluno(Aluno aluno) {
		if (ObjectUtils.isEmpty(aluno))
			throw new IllegalArgumentException();
		return hashAvaliacoes.values().stream()
				.filter(map -> map.getAluno().getMatricula().equals(aluno.getMatricula())).collect(Collectors.toList());
	}
	
	private List<BigDecimal> getNotasAluno(Aluno aluno, Turma turma) {
		
		if (ObjectUtils.isEmpty(aluno) || ObjectUtils.isEmpty(turma))
			throw new IllegalArgumentException();
		return hashAvaliacoes.entrySet().stream()
				.filter(map -> map.getValue().getAluno().equals(aluno) && map.getValue().getTurma().equals(turma))
				.map(map -> map.getValue().getNota()).collect(Collectors.toList());
	}
	
	private void verificarNota(List<BigDecimal> notas) {
		List<BigDecimal> NotasValidas = notas.stream()
				.filter(n -> n != null && n.compareTo(BigDecimal.ZERO) >= 0 && n.compareTo(BigDecimal.TEN) <= 0)
				.collect(Collectors.toList());
		if (!NotasValidas.equals(notas))
			throw new IllegalArgumentException();
	}
	
	public BigDecimal getMediaAluno(Aluno aluno, Turma turma) {
		List<BigDecimal> notas = new ArrayList<>();
		notas = getNotasAluno(aluno, turma);
		verificarNota(notas);
		
		return notas.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(notas.size()), 2,
				RoundingMode.HALF_UP);
	}
	
	public StatusAcademico getStatusAluno(Aluno aluno, Turma turma) {
		List<BigDecimal> notas = new ArrayList<>();
		notas = getNotasAluno(aluno, turma);
		verificarNota(notas);
		if (qtdAvaliacoesCadastradas + 1 == 0 || qtdAvaliacoesCadastradas + 1 == 1)
			return StatusAcademico.REPROVADO;
		else if (qtdAvaliacoesCadastradas + 1 == 2)
			return StatusAcademico.PROVA_FINAL;
		
		else {
			BigDecimal media = getMediaAluno(aluno, turma);
			
			if (media.compareTo(BigDecimal.valueOf(6)) >= 0)
				return StatusAcademico.APROVADO;
			else if (media.compareTo(BigDecimal.valueOf(4)) < 0)
				return StatusAcademico.REPROVADO;
			return StatusAcademico.PROVA_FINAL;
		}
	}
	
}
