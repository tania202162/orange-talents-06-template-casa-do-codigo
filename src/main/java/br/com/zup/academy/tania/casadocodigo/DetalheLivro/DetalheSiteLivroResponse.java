package br.com.zup.academy.tania.casadocodigo.DetalheLivro;

import java.math.BigDecimal;
import java.time.format.DateTimeFormatter;

import br.com.zup.academy.tania.casadocodigo.novolivro.Livro;

public class DetalheSiteLivroResponse {

	private DetalheSiteAutorResponse autor;
	private String titulo;
	private String isbn;
	private int pagina;
	private BigDecimal preco;
	private String resumo;
	private String sumario;
	private String data;

	public DetalheSiteLivroResponse(Livro livro) {

		titulo = livro.getTitulo();
		// autor = livro.getAutor();
		autor = new DetalheSiteAutorResponse(livro.getAutor()); // se fosse trabalhar com mais dados do autor
		isbn = livro.getIsbn();
		pagina = livro.getPagina();
		preco = livro.getPreco();
		resumo = livro.getResumo();
		sumario = livro.getSumario();
		// String dataFormatada = livro.getDataFormatada();
		data = livro.getData().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
	}

	public String getData() {
		return data;
	}

	public DetalheSiteAutorResponse getAutor() {
		return autor;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getIsbn() {
		return isbn;
	}

	public int getPagina() {
		return pagina;
	}

	public BigDecimal getPreco() {
		return preco;
	}

	public String getResumo() {
		return resumo;
	}

	public String getSumario() {
		return sumario;
	}

}
