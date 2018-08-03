package br.com.cariocadev.ProjetoMatrix;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;

public class CalculadoraSalario {
	
	public void verificarValor(BigDecimal salarioBruto) {
		if (salarioBruto == null || salarioBruto.compareTo(BigDecimal.ZERO) == 0)
			throw new IllegalArgumentException();
	}
	
	public void verificarIdade(Integer idade) {
		if (idade == null || idade < 0)
			throw new IllegalArgumentException();
	}
	
	public BigDecimal calculaDesconto(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		return salarioBruto.multiply(percentualImpostoINSS.divide(BigDecimal.valueOf(100))).setScale(2,
				RoundingMode.HALF_UP);
	}
	
	public BigDecimal getSalarioLiquido(BigDecimal salarioBruto, BigDecimal percentualImpostoINSS) {
		verificarValor(salarioBruto);
		
		return salarioBruto.subtract(calculaDesconto(salarioBruto, percentualImpostoINSS)).setScale(2,
				RoundingMode.HALF_UP);
	}
	
	public BigDecimal getValorINSS(BigDecimal salarioBruto) {
		verificarValor(salarioBruto);
		
		if (salarioBruto.compareTo(new BigDecimal(1693.72)) < 0)
			return calculaDesconto(salarioBruto, BigDecimal.valueOf(8));
		else if (salarioBruto.compareTo(new BigDecimal(2822.90)) < 0)
			return calculaDesconto(salarioBruto, BigDecimal.valueOf(9));
		
		return calculaDesconto(salarioBruto, BigDecimal.valueOf(11));
	}
	
	public Map<Integer, BigDecimal> IdadePrecoPlanoSaude = new HashMap<Integer, BigDecimal>();
	
	public void prepararMap() {
		
		double valor = 75.00;
		for (int i = 0; i <= 60; i++) {
			valor = i == 0 || i % 10 != 0 ? valor : (valor + (valor * 0.5));
			IdadePrecoPlanoSaude.put(Integer.valueOf(i), BigDecimal.valueOf(valor).setScale(2, BigDecimal.ROUND_UP));
		}
	}
	
	public BigDecimal getValorPlanoDeSaude(Integer idade) {
		verificarIdade(idade);
		if (IdadePrecoPlanoSaude.isEmpty())
			prepararMap();
		return idade > 60 ? IdadePrecoPlanoSaude.get(60) : IdadePrecoPlanoSaude.get(idade);
	}
}