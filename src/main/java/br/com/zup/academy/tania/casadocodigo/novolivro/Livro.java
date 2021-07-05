package br.com.zup.academy.tania.casadocodigo.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;

import br.com.zup.academy.tania.casadocodigo.novacategoria.*;
import br.com.zup.academy.tania.casadocodigo.novoautor.*;

@Entity
public class Livro {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	private String titulo;

	@Column(nullable = false)
	@NotBlank
	@Size(max = 500)
	private String resumo;

	@Column(nullable = false)
	@NotBlank
	private String sumario;

	@Column(nullable = false)
	@NotNull
	@Min(20)
	private BigDecimal preco;

	@Min(100)
	@Column(nullable = false)
	private int pagina;

	@NotBlank
	@Column(nullable = false)
	private String isbn;

	@NotNull
	@Future
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private  LocalDate data; // publicacao 
	
	@ManyToOne
	private @NotNull @Valid Categoria categoria;
	public Categoria getCategoria() {
		return categoria;
	}	
			
	@ManyToOne
	private @NotNull @Valid Autor autor;
	public Autor getAutor() {
		return autor;
	}
	
	
	public String getTitulo() {
		return titulo;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public int getPagina() {
		return pagina;
	}

	public String getIsbn() {
		return isbn;
	}

	public LocalDate getData() {
		return data;   
	}
		
	public Long getId() {
		return id;
	}

	public Livro( @NotNull @Future LocalDate data, @NotBlank String isbn,@NotNull @Min(100) int pagina,@Min(20) @NotNull BigDecimal preco,
			@NotBlank @Size(max = 500) String resumo, @NotBlank String sumario, @NotBlank String titulo,  
			@NotNull @Valid Autor autor ,@Valid @NotNull Categoria categoria) {
		      
       	this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.data = data;
		this.autor = autor;
		this.categoria = categoria;
	}
		
	@Override
	public String toString() {
		return "Livro: [id= " + id + ",titulo=" + titulo + ", sumario=" + sumario + ", preco=" + preco + ", pagina="
				+ pagina + ",isbn=" + isbn + ",data(yyyy-MM-dd)=" + data + ", autor_id=" + autor + ", categoria_id=" + categoria + "]";
	} 
	public Livro(){
	}
}