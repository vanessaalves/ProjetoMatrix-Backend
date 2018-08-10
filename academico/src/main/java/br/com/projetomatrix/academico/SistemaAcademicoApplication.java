package br.com.projetomatrix.academico;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SistemaAcademicoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(SistemaAcademicoApplication.class, args);
		
		SistemaAcademicoService sistemaAcademicoService = new SistemaAcademicoService();
		
		Aluno aluno1 = new Aluno();
		aluno1.setNome("Vanessa");
		aluno1.setEndereco("Rua tal");
		aluno1.setTelefone("5236222");
		aluno1.setStatus(Status.ATIVO);
		sistemaAcademicoService.cadastrarAluno(aluno1);
		
		Professor professor1 = new Professor();
		professor1.setNome("Ulisses");
		professor1.setEndereco("Rua A");
		professor1.setStatus(Status.ATIVO);
		professor1.setTelefone("20000");
		professor1.setTitulo(Titulo.DOUTORADO);
		sistemaAcademicoService.cadastrarProfessor(professor1);
		
		Coordenador coordenador1 = new Coordenador();
		coordenador1.setEndereco("jeneeaeu");
		coordenador1.setNome("Gabriel");
		coordenador1.setStatus(Status.ATIVO);
		coordenador1.setTelefone("2215111");
		coordenador1.setTitulo(Titulo.ESPECIALIZACAO);
		sistemaAcademicoService.cadastrarCoordenador(coordenador1);
		
		Curso curso1 = new Curso();
		curso1.setBibliografia("blablalba");
		curso1.setCargaHoraria(30);
		curso1.setCoordenador(coordenador1);
		sistemaAcademicoService.cadastrarCurso(curso1);
		
		Disciplina disc1 = new Disciplina();
		disc1.setDescricao("Disc1");
		disc1.setCurso(curso1);
		;
		disc1.setDescricao("ejjauhea");
		sistemaAcademicoService.cadastrarDisciplina(disc1);
		
		Horario horario1 = new Horario();
		horario1.setDiaDaSemana(3);
		horario1.setHoraInicio(LocalTime.of(19, 00));
		horario1.setHoraFim(LocalTime.of(20, 00));
		sistemaAcademicoService.cadastrarHorario(horario1);
		
		Turma turma1 = new Turma();
		turma1.setSemestre(2);
		turma1.setAnoLetivo(2018);
		turma1.setDataAbertura(LocalDate.of(2018, 10, 2));
		turma1.setDisciplina(disc1);
		turma1.setProfessor(professor1);
		
		sistemaAcademicoService.cadastrarTurma(turma1);
		
		sistemaAcademicoService.cadastrarAlunosEmTurmas(aluno1, turma1);
		
		sistemaAcademicoService.cadastrarProfessorEmTurmas(professor1, turma1);
		
		Avaliacao av1 = new Avaliacao();
		
		av1.setAluno(aluno1);
		av1.setDataRealizacao(LocalDate.of(2018, 12, 11));
		av1.setDescricao("Prova de Matematica");
		av1.setModoAvaliacao(ModoAvaliacao.ONLINE);
		av1.setNota(BigDecimal.valueOf(10));
		av1.setResponsavelPelaAplicacao(professor1);
		av1.setTurma(turma1);
		sistemaAcademicoService.cadastrarAvaliacao(av1);
		
		Avaliacao av2 = new Avaliacao();
		av2.setAluno(aluno1);
		av2.setDataRealizacao(LocalDate.of(2018, 12, 11));
		av2.setDescricao("Prova de Matematica");
		av2.setModoAvaliacao(ModoAvaliacao.ONLINE);
		av2.setNota(BigDecimal.valueOf(5));
		av2.setResponsavelPelaAplicacao(professor1);
		av2.setTurma(turma1);
		sistemaAcademicoService.cadastrarAvaliacao(av2);
		
		Avaliacao av3 = new Avaliacao();
		
		av3.setAluno(aluno1);
		av3.setDataRealizacao(LocalDate.of(2018, 12, 11));
		av3.setDescricao("Prova de Matematica");
		av3.setModoAvaliacao(ModoAvaliacao.ONLINE);
		av3.setNota(BigDecimal.valueOf(8));
		av3.setResponsavelPelaAplicacao(professor1);
		av3.setTurma(turma1);
		sistemaAcademicoService.cadastrarAvaliacao(av3);
		
		System.out.println(turma1.getCodigo());
		
	}
}
