package br.com.zup.academy.tania.casadocodigo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.zup.academy.tania.casadocodigo.novolivro.Livro;

@Repository
public interface LivroRepository  extends JpaRepository<Livro, Long>{
	
	
}
