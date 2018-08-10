package br.com.projetomatrix.academico;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class CoordenadorService {
	
	private int i = 0;
	private Map<String, Coordenador> hashCoordenadores = new HashMap<>();
	
	public Coordenador cadastrarCoordenador(Coordenador coordenador) {
		if (ObjectUtils.isEmpty(coordenador))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(coordenador.getMatricula()) && hashCoordenadores.containsKey(coordenador.getMatricula()))
			return atualizarCoordenador(coordenador);
		
		coordenador.setMatricula(gerarMatricula(coordenador));
		hashCoordenadores.put(coordenador.getMatricula(), coordenador);
		
		return coordenador;
	}
	
	public void removerCoordenador(Coordenador coordenador) {
		if (ObjectUtils.isEmpty(coordenador))
			throw new IllegalArgumentException();
		
		hashCoordenadores.remove(coordenador.getMatricula());
	}
	
	public Coordenador atualizarCoordenador(Coordenador coordenador) {
		if (ObjectUtils.isEmpty(coordenador) || !hashCoordenadores.containsKey(coordenador.getMatricula()))
			throw new IllegalArgumentException();
		hashCoordenadores.put(coordenador.getMatricula(), coordenador);
		
		return coordenador;
	}
	
	public Coordenador recuperarCoordenador(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashCoordenadores.get(codigo);
	}
	
	public String gerarMatricula(Coordenador coordenadorNovo) {
		String ano = Integer.toString(LocalDateTime.now().getYear());
		int mes = LocalDateTime.now().getMonthValue();
		String semestre = mes <= 6 ? "1" : "2";
		String matricula = ano + semestre + i++;
		
		return matricula;
	}
}
