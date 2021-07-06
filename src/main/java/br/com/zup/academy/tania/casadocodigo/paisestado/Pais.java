package br.com.zup.academy.tania.casadocodigo.paisestado;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Pais {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	private String nome;
		
	public Pais(@NotBlank String nome) {
	this.nome = nome;
	}
	
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
		
	@Override
	public String toString() {
		return "Pais: [id= " + id + ",Pais=" + nome + "]";
	}
	
	public Pais() {
		}

}