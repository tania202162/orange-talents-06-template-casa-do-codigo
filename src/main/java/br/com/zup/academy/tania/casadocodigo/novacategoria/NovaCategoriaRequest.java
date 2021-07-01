package br.com.zup.academy.tania.casadocodigo.novacategoria;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import br.com.zup.academy.tania.casadocodigo.Validador.UniqueValue;

public class NovaCategoriaRequest {

	@NotBlank
	@NotNull
	@NotEmpty
	@Size(max = 100)
	@Column(nullable = false)
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;
	

	public String getNome() {
		return nome;
	}
	
	public NovaCategoriaRequest() {
	}

	public NovaCategoriaRequest(@NotBlank @NotNull @NotEmpty @Size(max = 100) String nome) {
		super();
		this.nome = nome;
	}

	public Categoria toModel() {
		return new Categoria(this.nome);
	}
}
