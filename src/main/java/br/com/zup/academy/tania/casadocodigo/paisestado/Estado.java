package br.com.zup.academy.tania.casadocodigo.paisestado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	private String nome;

	@ManyToOne
	private @NotNull @Valid Pais pais;

	public Pais getPais() {
		return pais;
	}

	public Estado(@NotBlank String nome, @Valid @NotNull Pais pais) {
		this.nome = nome;
		this.pais = pais;
	}

	public Estado() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Estado: [id= " + id + ",nome=" + nome + ", pais_id=" + pais + "]";
	}
}