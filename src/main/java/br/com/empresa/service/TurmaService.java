package br.com.empresa.service;

import java.util.List;
import java.util.Optional;

import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.empresa.entity.Turma;
import br.com.empresa.repository.TurmaRepository;


@Service
public class TurmaService {
	
	@Autowired
	TurmaRepository repo;
	
	//criar metodo de listar todas as turmas
	public List<Turma> ListaTodasTurmas(){
		return repo.findAll();
	}
	
	
	//criar um metodo para trazer uma turma por ID
	public Turma buscaPorID(Integer id) throws ObjectNotFoundException{
		Optional<Turma> turma = repo.findById(id);
		return turma.orElseThrow(() -> new ObjectNotFoundException(null, "Turma não encontrada"));
	}
	
	
	
	//criar um metodo para inserir a turma
	public Turma salvar(Turma turma) {
		return repo.save(turma);
	}
	
	
	
	//criar um metodo para fazer update da turma
	public Turma alterar(Turma objTurma) {
		Turma turma = buscaPorID(objTurma.getId());
		turma.setNome(objTurma.getNome());
		return salvar(turma);
	}
	
	
	
	//criar um metodo para excluir a turma
	public void excluir(Integer id) {
		repo.deleteById(id);
	}
}
