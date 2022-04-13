package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "avaliacoes")
public class Avaliacao implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -120121262211435824L;

	@EmbeddedId
	private AlunoDisciplina alunoDisciplina;
	
	private String conceito;
	
	//idAluno
	
	//idDisciplina
}
