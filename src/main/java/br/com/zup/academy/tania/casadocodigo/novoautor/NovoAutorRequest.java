package br.com.zup.academy.tania.casadocodigo.novoautor;


import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class NovoAutorRequest {
	
	
	@NotBlank 
	@Column(nullable=false)
	private String nome;
	@NotBlank 	
	@Email
	@Column(nullable=false)
	private String email;
	@NotBlank
	@Size(max = 400)
	@Column(nullable=false, length = 400)
	private String descricao;
			
	public NovoAutorRequest(@NotBlank String nome,	
			@NotBlank @Email String email, 
			@NotBlank @Size(max = 400) String descricao)
	 {
		super();
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
	}

	public Autor toModel() {
		return new Autor(this.nome, this.email,this.descricao);
	}
}
