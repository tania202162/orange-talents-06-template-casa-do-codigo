package br.com.zup.academy.tania.casadocodigo.DetalheLivro;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import br.com.zup.academy.tania.casadocodigo.novolivro.Livro;

@RestController
public class DetalheLivroSiteController {

	@PersistenceContext
	private EntityManager manager;

	@GetMapping(value = "/livros/{id}")
	public ResponseEntity<?> detalhe(@PathVariable("id") Long id) {
		Livro livroBuscado = manager.find(Livro.class, id);

		if (livroBuscado == null) {
			return ResponseEntity.notFound().build(); // erro 404
		}
		DetalheSiteLivroResponse detalheSiteLivroResponse = new DetalheSiteLivroResponse(livroBuscado);
		return ResponseEntity.ok(detalheSiteLivroResponse);

	}

}
