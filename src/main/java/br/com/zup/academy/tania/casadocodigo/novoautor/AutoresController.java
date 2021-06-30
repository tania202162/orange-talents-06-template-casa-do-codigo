package br.com.zup.academy.tania.casadocodigo.novoautor;

import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.tania.casadocodigo.repository.AutorRepository;

@RestController
//2
public class AutoresController {

	@Autowired
	private AutorRepository autorRepository;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/autores")
	@Transactional
	// 1
	// 2
	public String cria(@RequestBody @Valid NovoAutorRequest request) {
		Autor autor = request.toModel();
		Optional<Autor> listaEmail = autorRepository.findByEmail(autor.getEmail());
		if (listaEmail.isPresent()) {
			return "Atenção!!! Email já existente!!";
		} else {
			manager.persist(autor);
			return autor.toString();
		}
	}
}