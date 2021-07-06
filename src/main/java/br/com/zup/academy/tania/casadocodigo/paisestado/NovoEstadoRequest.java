package br.com.zup.academy.tania.casadocodigo.paisestado;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.zup.academy.tania.casadocodigo.Validador.UniqueValue;
import br.com.zup.academy.tania.casadocodigo.novolivro.ExistsId;

public class NovoEstadoRequest {

	@NotBlank
	@UniqueValue(domainClass = Estado.class, fieldName = "nome")
	private String nome;

	@NotNull
	@ExistsId(domainClass = Pais.class, fieldName = "id")
	private Long pais_id;

	@PersistenceContext
	private EntityManager manager;

	public NovoEstadoRequest(@NotBlank String nome, @NotNull @Valid Long pais_id) {
		super();
		this.nome = nome;
		this.pais_id = pais_id;
	}

	@Override
	public String toString() {
		return "NovoEstadoRequest: [nome= " + nome + ",idPais=" + pais_id + "]";
	}

	public Estado toModel(EntityManager manager) {
		// @NotNull Pais pais = manager.find(Pais.class, idPais);
		return new Estado(nome, manager.find(Pais.class, pais_id));
	}
}