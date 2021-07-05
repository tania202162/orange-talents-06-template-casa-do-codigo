package br.com.zup.academy.tania.casadocodigo.novolivro.LivroDto;

import br.com.zup.academy.tania.casadocodigo.novolivro.Livro;

public class LivroDto {
	private Long id;
	private String titulo;

	public LivroDto(Livro livro) {
		this.id = livro.getId();
		this.titulo = livro.getTitulo();
	}

	public Long getId() {
		return id;
	}

	public String getTitulo() {
		return titulo;
	}
}