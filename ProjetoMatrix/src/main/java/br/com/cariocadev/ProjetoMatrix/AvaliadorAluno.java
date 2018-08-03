package br.com.cariocadev.ProjetoMatrix;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Collections;

public class AvaliadorAluno {
	public void verificarNota(BigDecimal... notas) {
		List<BigDecimal> NotasValidas = Stream.of(notas)
				.filter(n -> n != null && n.compareTo(BigDecimal.ZERO) >= 0 && n.compareTo(BigDecimal.TEN) <= 0)
				.collect(Collectors.toList());
		if (NotasValidas.size() != 3)
			throw new IllegalArgumentException();
}
	
	public BigDecimal getMaiorNota(BigDecimal[] notas) {
		if (notas == null || notas.length == 0)
			throw new IllegalArgumentException();
		
		Collections.sort(Arrays.asList(notas), Collections.reverseOrder());
		return notas[0];
	}
	
	public BigDecimal getMedia(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		verificarNota(nota1, nota2, nota3);
		
		return nota1.add(nota2.add(nota3)).divide(BigDecimal.valueOf(3), 2, RoundingMode.HALF_UP);
	}
	
	public String getStatus(BigDecimal nota1, BigDecimal nota2, BigDecimal nota3) {
		verificarNota(nota1, nota2, nota3);
		BigDecimal media = getMedia(nota1, nota2, nota3);
		
		if (media.compareTo(BigDecimal.valueOf(6)) >= 0)
			return "APROVADO";
		else if (media.compareTo(BigDecimal.valueOf(4)) < 0)
			return "REPROVADO";
		
		return "PROVA_FINAL";
	}	
}