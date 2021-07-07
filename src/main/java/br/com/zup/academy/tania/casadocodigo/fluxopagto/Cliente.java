package br.com.zup.academy.tania.casadocodigo.fluxopagto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
public class Cliente {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	@Email
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@NotBlank
	private String sobrenome;

	@Column(nullable = false)
	@NotBlank
	private String documento; // cpf/cnpj

	@Column(nullable = false)
	@NotBlank
	private String endereco;

	@Column(nullable = false)
	@NotBlank
	private String complemento;

	@Column(nullable = false)
	@NotBlank
	private String cidade;

	@Column(nullable = false)
	@NotBlank
	private String pais;

	private String estado;

	@Column(nullable = false)
	@NotBlank
	private String telefone;

	@Column(nullable = false)
	@NotBlank
	private String cep;

	public Cliente(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
			@NotBlank String documento, @NotBlank String endereco, @NotBlank String complemento,
			@NotBlank String cidade, @NotBlank String pais, String estado, @NotBlank String telefone,
			@NotBlank String cep) {

		this.email = email;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.documento = documento;
		this.endereco = endereco;
		this.complemento = complemento;
		this.cidade = cidade;
		this.pais = pais;
		this.estado = estado;
		this.telefone = telefone;
		this.cep = cep;
	}

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getDocumento() {
		return documento;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public String getPais() {
		return pais;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	@Override
	public String toString() {
		return "Cliente: [id= " + id + "]";
		/*
		 * ",email=" + email + ", nome=" + nome + ", sobrenome=" + sobrenome +
		 * ", documento=" + documento + ",endereco=" + endereco + ",complemento=" +
		 * complemento + ", cidade=" + cidade + ",pais=" + pais + ", estado=" + estado +
		 * ", telefone=" + telefone + ", cep=" + cep +
		 */

	}
}
