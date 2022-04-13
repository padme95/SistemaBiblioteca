package br.com.empresa.resource;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.empresa.entity.Aluno;
import br.com.empresa.entity.AlunoDisciplina;
import br.com.empresa.entity.Avaliacao;
import br.com.empresa.entity.Disciplina;
import br.com.empresa.service.AvaliacaoService;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoResource {
	
	@Autowired
	private AvaliacaoService service;
	
	
	@GetMapping
	public ResponseEntity<List<Avaliacao>> listarAvaliacao(){
		List<Avaliacao> listaAvaliacao = service.findAll();
		return ResponseEntity.ok().body(listaAvaliacao);
	}
	
	@PostMapping
	public ResponseEntity<Void>inserir(@RequestBody Avaliacao objAvaliacao){
		
		objAvaliacao = service.save(objAvaliacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(objAvaliacao.getAlunoDisciplina()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	
	@GetMapping("/{idAluno}/{idDiscipina}")
	public ResponseEntity<Avaliacao> buscarAvaliacaoAlunoPorDisciplina(@PathVariable Integer idAluno, Integer idDisciplina){
	Aluno aluno = new Aluno();
	aluno.setId(idAluno);
	
	Disciplina disciplina = new Disciplina();
	
	AlunoDisciplina alunoDisciplina = new AlunoDisciplina();
	alunoDisciplina.setAluno(aluno);
	alunoDisciplina.setDisciplina(disciplina);
	
	Avaliacao avaliacao = service.buscarNotaAlunoDisciplina(alunoDisciplina);
	
	return ResponseEntity.ok().body(avaliacao);
	 
	}
}
