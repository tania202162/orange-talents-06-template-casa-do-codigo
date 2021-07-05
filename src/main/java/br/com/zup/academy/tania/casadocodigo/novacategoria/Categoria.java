package br.com.zup.academy.tania.casadocodigo.novacategoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Categoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotBlank
	@NotNull
	@NotEmpty
	@Size(max = 100)
	private String nome;

	public String getNome() {
		return nome;
	}

	public Long getId() {
		return id;
	}
	@Deprecated
	public Categoria() {
	}

	public Categoria(@NotBlank @NotNull @NotEmpty @Size(max = 100) String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return "Autor: [id= " + id + ",nome=" + nome + "]";
	}
}
