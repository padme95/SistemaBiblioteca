package br.com.empresa.entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;


import lombok.Data;

@Data
@Embeddable
public class AlunoDisciplina implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4649024223763107012L;

	@ManyToOne
	private Aluno aluno;
	
	@ManyToOne
	private Disciplina disciplina;
	
	
}
