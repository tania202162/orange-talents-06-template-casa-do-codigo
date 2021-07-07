package br.com.zup.academy.tania.casadocodigo.fluxopagto;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import br.com.zup.academy.tania.casadocodigo.Validador.UniqueValue;
import br.com.zup.academy.tania.casadocodigo.Validador.ValidaCpfCnpj;

public class ClienteRequest {

	@Column(nullable = false)
	@NotBlank
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotBlank
	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	@NotBlank
	private String sobrenome;

	@Column(nullable = false)
	@NotBlank
	@UniqueValue(domainClass = Cliente.class, fieldName = "documento")
	@ValidaCpfCnpj
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
	
		public ClienteRequest(@NotBlank String email, @NotBlank String nome, @NotBlank String sobrenome,
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

	public Cliente toModel() {
		return new Cliente(this.email, this.nome, this.sobrenome, this.documento, this.endereco, this.complemento,
				this.cidade, this.pais, this.estado, this.telefone, this.cep);
	}
}