package br.com.zup.academy.tania.casadocodigo.novacategoria;
import javax.validation.constraints.NotNull;

import java.net.http.HttpResponse;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.tania.casadocodigo.repository.CategoriaRepository;

@RestController
public class CategoriaController {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/categorias")
	@Transactional
	public String cria(@RequestBody @Valid NovaCategoriaRequest request) {
		Categoria categoria = request.toModel();
		Optional<Categoria> listaCategoria = categoriaRepository.findByNome(categoria.getNome());
		manager.persist(categoria); 
		return categoria.toString();
		
		
	/*	
		if (listaCategoria.isPresent()) {
			return new ResponseEntity<Categoria> (HttpStatus.BAD_REQUEST);
		} 
		
		  else {
			  manager.persist(categoria); 
			  return new ResponseEntity<Categoria> (categoria,HttpStatus.OK);
		  } */
		  
	}
	
}