package br.com.zup.academy.tania.casadocodigo.paisestado;

import javax.validation.constraints.NotBlank;
import br.com.zup.academy.tania.casadocodigo.Validador.UniqueValue;

public class NovoPaisRequest {

	@NotBlank
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}