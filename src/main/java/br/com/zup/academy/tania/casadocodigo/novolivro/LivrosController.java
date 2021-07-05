package br.com.zup.academy.tania.casadocodigo.novolivro;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.tania.casadocodigo.novolivro.LivroDto.LivroDto;
import br.com.zup.academy.tania.casadocodigo.repository.LivroRepository;

@RestController
public class LivrosController {

	@Autowired
	private LivroRepository livroRepository;

	@PersistenceContext
	private EntityManager manager;

	@PostMapping(value = "/livros")
	@Transactional
	public String cria(@RequestBody @Valid NovoLivroRequest request) {
		Livro novoLivro = request.toModel(manager);
		manager.persist(novoLivro);
		return novoLivro.toString();
	}

	@GetMapping(value = "/livros")
	public List<LivroDto> lista() {
		List<Livro> livros = livroRepository.findAll();
		List<LivroDto> livroDto = new ArrayList<>();
		livros.forEach(livro -> livroDto.add(new LivroDto(livro)));
		return livroDto;
	}
}