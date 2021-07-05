package br.com.zup.academy.tania.casadocodigo.DetalheLivro;

import br.com.zup.academy.tania.casadocodigo.novoautor.Autor;

public class DetalheSiteAutorResponse {

	private String nome;
	private String descricao;

	public DetalheSiteAutorResponse(Autor autor) {

		nome = autor.getNome();
		descricao = autor.getDescricao();
	}

	public String getNome() {
		return nome;
	}

	public String getDescricao() {
		return descricao;
	}

}
