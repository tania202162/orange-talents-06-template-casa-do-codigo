package br.com.zup.academy.tania.casadocodigo.novolivro;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PersistenceContext;
import javax.validation.Valid;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonFormat.Shape;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import br.com.zup.academy.tania.casadocodigo.Validador.UniqueValue;
import br.com.zup.academy.tania.casadocodigo.novacategoria.Categoria;
import br.com.zup.academy.tania.casadocodigo.novoautor.Autor;

public class NovoLivroRequest {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	@NotBlank
	@UniqueValue(domainClass = Livro.class, fieldName = "titulo")
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

	@NotNull
	@Min(100)
	@Column(nullable = false)
	private int pagina;

	@NotBlank
	@Column(nullable = false)
	@UniqueValue(domainClass = Livro.class, fieldName = "isbn")
	private String isbn;

	@NotNull
	@Future
	@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
	@JsonFormat(pattern = "dd/MM/yyyy", shape = Shape.STRING)
	private  LocalDate data; // publicacao 
	
	@NotNull
	@ExistsId(domainClass = Categoria.class, fieldName = "id")
	private Long categoria_id;

	@NotNull
	@ExistsId(domainClass = Autor.class, fieldName = "id")
	private Long autor_id;
		
	@PersistenceContext
	private EntityManager manager;
	
		
	public NovoLivroRequest(@NotNull @Future LocalDate data, @NotBlank String isbn, @Min(100) int pagina,
			@NotNull @Min(20) BigDecimal preco, @NotBlank @Size(max = 500) String resumo, @NotBlank String sumario,
			@NotBlank String titulo, @NotNull @Valid Long autor_id , @NotNull @Valid  Long categoria_id) {

		super();
		this.titulo = titulo;
		this.resumo = resumo;
		this.sumario = sumario;
		this.preco = preco;
		this.pagina = pagina;
		this.isbn = isbn;
		this.data = data;
		this.autor_id =  autor_id;
		this.categoria_id = categoria_id;
	}

	public Livro toModel(EntityManager manager) {
		@NotNull Autor autor = manager.find(Autor.class, autor_id);
		@NotNull Categoria categoria = manager.find(Categoria.class, categoria_id);
		return new Livro(data, isbn, pagina, preco, resumo, sumario, titulo, autor, categoria);
	}

	}