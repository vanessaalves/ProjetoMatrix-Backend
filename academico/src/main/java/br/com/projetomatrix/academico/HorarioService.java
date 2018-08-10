package br.com.projetomatrix.academico;

import java.util.HashMap;
import java.util.Map;

import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

public class HorarioService {
	private int i = 1;
	private Map<String, Horario> hashHorarios = new HashMap<>();
	
	public Horario cadastrarHorario(Horario horario) {
		if (ObjectUtils.isEmpty(horario))
			throw new IllegalArgumentException();
		
		if (!StringUtils.isEmpty(horario.getCodigo()) && hashHorarios.containsKey(horario.getCodigo()))
			return atualizarHorario(horario);
		
		horario.setCodigo(gerarCodigo(horario));
		hashHorarios.put(horario.getCodigo(), horario);
		
		return horario;
	}
	
	public void removerHorario(Horario horario) {
		if (ObjectUtils.isEmpty(horario))
			throw new IllegalArgumentException();
		
		hashHorarios.remove(horario.getCodigo());
	}
	
	public Horario atualizarHorario(Horario horario) {
		if (ObjectUtils.isEmpty(horario) || !hashHorarios.containsKey(horario.getCodigo()))
			throw new IllegalArgumentException();
		hashHorarios.put(horario.getCodigo(), horario);
		
		return horario;
	}
	
	public Horario recuperarHorario(String codigo) {
		if (StringUtils.isEmpty(codigo))
			throw new IllegalArgumentException();
		
		return hashHorarios.get(codigo);
	}
	
	public String gerarCodigo(Horario horario) {
		String codigo = "HOR" + i++;
		
		return codigo;
	}
}
