package br.com.zup.academy.tania.casadocodigo.novoautor;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	@NotBlank
	private String nome;
	@Column(nullable = false)
	@NotBlank
	@Email
	private String email;
	@Column(nullable = false)
	@NotBlank
	@Size(max = 400)
	private String descricao;
	private LocalDateTime instanteCriacao = LocalDateTime.now();

	public String getEmail() {
		return email;
	}

	@Deprecated
	public Autor() {
	}

	public Autor(@NotBlank String nome, // construtor
			@NotBlank @Email String email, @NotBlank @Size(max = 400) String descricao) {

		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	@Override
	public String toString() {
		return "Autor: [id= " + getId() + ",nome=" + nome + ", email=" + email + ", descricao=" + descricao
				+ ", instanteCriacao=" + instanteCriacao + "]";
	}

	public Long getId() {
		return id;
	}
}